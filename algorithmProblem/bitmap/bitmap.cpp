#include <iostream>
#include <fstream>

#include <cstring>

#include <cmath>

using namespace std;

ifstream fin("bitmap.inp");
ofstream fout("bitmap.out");

char finChar;
char dimB[201][201];
char dimD[40000];
int rowSize,columnSize;

char type;

int checkLine = 0;

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
	checkLine = 0;
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
	cout<<endl<<x<<" "<<xx<<" "<<y<<" "<<yy<<endl;

	int checkD = 0;
	int checkX = 0;
	int checkY = 0;
	if(x > xx)
	{
		checkX++;
		xx = x;
	}
	if(y > yy)
	{
		checkY++;
		yy = y;
	}
	cout<<"change "<<x<<" "<<xx<<" "<<y<<" "<<yy<<endl;

	for(int i = x;i<=xx;i++)
	{
		for(int j = y;j<=yy;j++)
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
	if(checkD != 0)
	{
		cout<<"D";
		fout<<"D";
		checkLine++;
		if(checkLine == 50)
		{
			cout<<endl;
			fout<<endl;
			checkLine = 0;
		}
		if(checkX == 0 && yy!=y)
		{
			if((xx+x+1)%2 == 0)
			{
				if((yy+y+1)%2 == 0)
				{
					Btype(x,(x+xx-1)/2,y,(y+yy-1)/2);
					Btype(x,(x+xx-1)/2,((y+yy-1)/2)+1,yy);
				}
				else if((yy+y+1)%2 != 0)
				{
					Btype(x,(x+xx-1)/2,y,(yy+y)/2);
					Btype(x,(x+xx-1)/2,((yy+y)/2)+1,yy);
				}
			}
			else if((xx+x+1)%2 != 0)
			{
				if((yy+y+1)%2 == 0)
				{
					Btype(x,(x+xx)/2,y,(y+yy-1)/2);
					Btype(x,(x+xx)/2,((y+yy-1)/2)+1,yy);
				}
				else if((yy+y+1)%2 != 0)
				{
					Btype(x,(x+xx)/2,y,(yy+y)/2);
					Btype(x,(x+xx)/2,((yy+y)/2)+1,yy);
				}
			}
//			Btype(x,ceil((xx)/2.0),y,floor((yy+y)/2.0));
//			Btype(x,ceil((xx)/2.0),ceil((yy+y)/2.0),yy);
		}
		if(checkY == 0 && xx!=x)
		{
			if((xx+x+1)%2 == 0)
			{
				if((yy+y+1)%2 == 0)
				{
					Btype(ceil((xx+x)/2.0),xx,y,(yy+y-1)/2);
					Btype(ceil((xx+x)/2.0),xx,((y+yy-1)/2)+1,yy);
				}
				else if((yy+y+1)%2 != 0)
				{
					Btype(ceil((xx+x)/2.0),xx,y,(yy+y)/2);
					Btype(ceil((xx+x)/2.0),xx,((yy+y)/2)+1,yy);
				}
			}
			else if((xx+x+1)%2 != 0)
			{
				if((yy+y+1)%2 == 0)
				{
					Btype(ceil((xx+x)/2.0)+1,xx,y,(yy+y-1)/2);
					Btype(ceil((xx+x)/2.0)+1,xx,((y+yy-1)/2)+1,yy);
				}
				else if((yy+y+1)%2 != 0)
				{
					Btype(ceil((xx+x)/2.0)+1,xx,y,(yy+y)/2);
					Btype(ceil((xx+x)/2.0)+1,xx,((yy+y)/2)+1,yy);
				}
			}
//			Btype(ceil((xx+x)/2.0),xx,y,floor((yy+y)/2.0));
//			Btype(ceil((xx+x)/2.0),xx,ceil((yy+y)/2.0),yy);
		}
	}
	else if(checkD == 0)
	{
		cout<<dimB[x][y];
		fout<<dimB[x][y];
		checkLine++;
		if(checkLine == 50)
		{
			cout<<endl;
			fout<<endl;
			checkLine = 0;
		}
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

				for(int i = 1;i<=rowSize;i++)
				{
					for(int j = 1;j<=columnSize;)
					{
						fin>>finChar;
						if(finChar == '\n')
							break;
						else
						{
							dimB[i][j] = finChar;
							cout<<finChar;
							j++;
						}
					}
					cout<<endl;
				}
				Btype(1,rowSize,1,columnSize);
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
					//	cout<<dimD[i];
						i++;
					}

					if(checkL < 50)
						break;
				}
//				cout<<endl;
			
			}

		}
		cout<<endl;
		fout<<endl;
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
