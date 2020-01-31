#include <iostream>
#include <cstring>

#include <cmath>

using namespace std;

char finChar;
char dimB[201][201];
char dimD[40000];
int rowSize,columnSize;

char type;

int checkLine = 0;

int checkIndex = 0;

string finString;
char *splitString;
int checkL = 0;

void finFunction();
void Dfout(int,int);
void Bfout(int,int);
void Btype(int,int,int,int);
void Dtype(int,int,int,int);
void init(int,int);

void init(int row,int col)
{
	int tmp = 0;
	checkIndex = checkLine = 0;
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
	if(x == xx && y == yy)
	{
		dimD[checkIndex] = dimB[x][y];
		checkIndex++;
		return;
	}
	int checkD = 0;

	for(int i = x;i <= xx;i++)
	{
		for(int j = y;j <= yy;j++)
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
		dimD[checkIndex] = 'D';
		checkIndex++;
		if(x != xx && y != yy)
		{
			
			Btype(x,(x+xx)/2,y,(y+yy)/2);		//1
			
			Btype(x,(x+xx)/2,((y+yy)/2)+1,yy);	//2
		
			Btype(((x+xx)/2)+1,xx,y,(y+yy)/2);	//3
		
			Btype(((x+xx)/2)+1,xx,((y+yy)/2)+1,yy);	//4
		}
		else if(x != xx && y == yy)
		{
			Btype(x,(x+xx)/2,y,y);		//1
			Btype(((x+xx)/2)+1,xx,y,y);	//3
		}
		else if(x == xx && y != yy)
		{
			Btype(x,x,y,(y+yy)/2);		//1
			Btype(x,x,((y+yy)/2)+1,yy);	//2
		}
	}
	else
	{
		dimD[checkIndex] = dimB[x][y];
		checkIndex++;
	}
}
void Bfout(int x,int y)
{
	int tmp = 0;

	cout<<"D";
	cout.width(4);
	cout<<x;
	cout.width(4);
	cout<<y<<endl;

	int ln = strlen(dimD);
	for(int i = 0;i<ln;i++)
	{
		if(dimD[i] == ' ')
			break;
		cout<<dimD[i];
		tmp++;
		if(tmp == 50)
		{
			tmp = 0;
			cout<<endl;
		}
	}
	if(tmp != 0)
		cout<<endl;
}

void Dtype(int x,int xx,int y,int yy)
{
	
	if(x == xx && y == yy)
	{
		dimB[x][y] = dimD[checkIndex];
		checkIndex++;
		return;
	}

	if(dimD[checkIndex] == 'D')
	{
		checkIndex++;

		if(x != xx && y != yy)
		{
			Dtype(x,(xx+x)/2,y,(y+yy)/2);		//1
			Dtype(x,(xx+x)/2,((y+yy)/2)+1,yy);	//2
			Dtype(((x+xx)/2)+1,xx,y,(y+yy)/2);	//3
			Dtype(((x+xx)/2)+1,xx,((y+yy)/2)+1,yy);	//4
		}
		else if(x != xx && y == yy)
		{
			Dtype(x,(xx+x)/2,y,y);		//1
			Dtype(((x+xx)/2)+1,xx,y,y);	//3
		}
		else if(x == xx && y != yy)
		{
			Dtype(x,x,y,(y+yy)/2);		//1
			Dtype(x,x,((y+yy)/2)+1,yy);	//2
		}
	}
	else
	{
		for(int i = x;i<=xx;i++)
		{
			for(int j = y;j<=yy;j++)
			{
				dimB[i][j] = dimD[checkIndex];
			}
		}
		checkIndex++;
	}
}
void Dfout(int x,int y)
{
	int tmp = 0;

	cout<<"B";
	cout.width(4);
	cout<<x;
	cout.width(4);
	cout<<y<<endl;

	for(int i = 1;i<=x;i++)
	{
		for(int j = 1;j<=y;j++)
		{
			tmp++;
			cout<<dimB[i][j];
			if(tmp == 50)
			{
				tmp = 0;
				cout<<endl;
			}
		}
	}
	if(tmp != 0)
	{
		cout<<endl;
	}
}

void finFunction()
{
	while(1)
	{
		char t1;
		int rowSize,columnSize;
		cin>>t1;

		if(t1 == '#')
			break;

		cin>>rowSize>>columnSize;


		char finChar;

		if(t1 == 'B')
		{
			for(int i = 1;i <= rowSize;i++)
			{
				for(int j = 1;j <= columnSize;j++)
				{
					cin>>finChar;
					if(finChar == '\n')
						break;
					else
						dimB[i][j] = finChar;
				}
			}
			Btype(1,rowSize,1,columnSize);
			Bfout(rowSize,columnSize);
		}
		else if(t1 == 'D')
		{
			for(int i = 0;;)
			{
				cin>>finString;
				splitString = (char *)finString.c_str();
				checkL = strlen(splitString);
				for(int j = 0;j < checkL;j++)
				{
					dimD[i] = splitString[j];
					i++;
				}
				if(checkL < 50)
					break;
			}
			Dtype(1,rowSize,1,columnSize);
			Dfout(rowSize,columnSize);
		}
		init(rowSize,columnSize);
	}
}
int main()
{
	finFunction();


	return 0;
}
