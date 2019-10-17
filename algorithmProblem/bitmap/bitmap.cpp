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
void Btype();
void Dtype();
void init(int,int);

void init(int row,int col)
{

	return;
}

void Btype()
{
	return;
}

void Dtype()
{
	return;
}

void finFunction()
{
	while(1)
	{
		int tmp;

		getline(fin,finString);
		splitString = (char *)finString.c_str();
		checkL = strlen(splitString);

		if(splitString[0] == '#')
			break;
		else if(splitString[1] == ' ')
		{
			rowSize = 0,columnSize = 0;
			for(int i = 2;;i++)
			{
				if(splitString[i] != ' ')
					rowSize = rowSize*10 + atoi(splitString[i]);
				else if(splitString[i] == ' ')
				{
					tmp = i;
					break;
				}
			}
			for(int i = tmp+1;;i++)
			{
				if(splitString[i] != ' ')
					columnSize = columnSize*10 + atoi(splitString[i]);
				else if(splitString[i] == '\n')
					break;
			}

		}
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
