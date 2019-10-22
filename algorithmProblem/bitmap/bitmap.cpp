#include <iostream>
#include <fstream>

#include <cstring>

using namespace std;

ifstream fin("bitmap.inp");
ofstream fout("bitmap.out");

char finChar;
char dimB[200][200];
char dimD[40000];
int rowSize,columnSize;

char type;


string finString;
char *splitString;
int checkL = 0;

void finFunction();
void foutFunction();
void Btype(int,int,int,int);
void Dtype();
void init(int,int);

void init(int row,int col)
{
	int tmp = 0;
	for(int i = 0;i<col;i++)
	{
		for(int j = 0;j<row;j++)
		{
			dimB[i][j] = ' ';
			dimD[tmp] = ' ';
			tmp++;
		}
	}

	return;
}

void Btype(int x,int xx,int y,int yy)
{
	int checkD = 0;
	for(int i = x;i<xx;i++)
	{
		for(int j = y;j<yy;j++)
		{
			if(dimB[x][y] != dimB[i][j])
			{
				checkD++;
				break;
			}
		}
		if(checkD != 0)
			break;
	}
//	cout<<"checkD "<<checkD<<endl;
	
	if(checkD == 0)
	{
		cout<<dimB[x][y];
	}
	else
	{
		cout<<"D";
//		int tmpx,tmpxx,tmpy,tmpyy;
//		tmpx
	}

}

void Dtype()
{
	return;
}

void finFunction()
{
	while(1)
	{
		getline(fin,finString);
		splitString = (char *)finString.c_str();
		checkL = strlen(splitString);

		if(splitString[0] == '#')
			break;
		else
		{
			int tmp;
			char finChar;
			if(splitString[0] == 'B' && splitString[1] == ' ')
			{
				rowSize = columnSize = 0;
				for(int i = 2;;i++)
				{
					if(splitString[i] == ' ')
					{
						tmp = i;
						break;
					}

					rowSize  = rowSize * 10 + splitString[i] - '0';
				}
				for(int i = tmp + 1;i < checkL;i++)
				{
					columnSize = columnSize * 10 + splitString[i] - '0';
				}
				cout<<rowSize<<" "<<columnSize<<endl;

				for(int i = 0;i<columnSize;i++)
				{
					for(int j = 0;j<rowSize;)
					{
						fin>>finChar;
						if(finChar == '\n')
							break;
						else
						{
							dimB[i][j] = finChar;
							j++;
						}
					}
				}
				Btype(0,rowSize,0,columnSize);
			}
			else if(splitString[0] == 'D' && splitString[1] == ' ')
			{
				rowSize = columnSize = 0;
				for(int i = 2;;i++)
				{
					if(splitString[i] == ' ')
					{
						tmp = i;
						break;
					}

					rowSize = rowSize * 10 + splitString[i] - '0';
				}
				for(int i = tmp + 1;i < checkL;i++)
				{
					columnSize = columnSize * 10 + splitString[i] - '0';
				}
				cout<<rowSize<<" "<<columnSize<<endl;

				tmp = 0;

				for(int i = 0;;)
				{
					getline(fin,finString);
					splitString = (char *)finString.c_str();
					checkL = strlen(splitString);
				
					for(int j = 0;j<checkL;j++)
					{
						dimD[i] = splitString[j];
						cout<<dimD[i];
						i++;
					}

					if(checkL < 50)
						break;
				}
				cout<<endl;
			
			}
		}
		
		init(rowSize,columnSize);
	}
	return;
}

int main()
{
	finFunction();

	fin.close();
	fout.close();

	return 0;
}
