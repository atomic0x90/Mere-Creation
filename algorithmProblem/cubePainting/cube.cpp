#include <iostream>
#include <fstream>

#include <cstring>

using namespace std;

ifstream fin("cube.inp");
ofstream fout("cube.out");

string finString;

char *splitString;

int finFunction();
void foutFunction(int);
int checkPainting();
int checkEOFFunction();

int finFunction()
{
	int checkNum;

	getline(fin,finString);
	splitString = (char *)finString.c_str();

	checkNum = checkEOFFunction();

	if(checkNum == 12)
	{
		cout<<"TRUE"<<endl;
		fout<<"TRUE"<<endl;
		return 1;
	}

	checkNum = checkPainting();

	foutFunction(checkNum);

	return 0;
}

void foutFunction(int num)
{
	if(num == 1)
	{
		cout<<"TRUE"<<endl;
		fout<<"TRUE"<<endl;
	}
	else if(num == 0)
	{
		cout<<"FALSE"<<endl;
		fout<<"FALSE"<<endl;
	}

	return ;
}

int checkEOFFunction()
{
	int checkEOF = 0;

	for(int i = 0; i < 12; i++)
	{
		if(splitString[0] == splitString[i])
			checkEOF++;
		else
			break;
	}
	
	return checkEOF;
}

int checkPainting()
{
	char firstCube[6];
	char secondCube[6];

	for(int i = 0;i < 6;i++)
	{
		firstCube[i] = splitString[i];
		secondCube[i] = splitString[6+i];
	}

	return 0;
}

int main()
{
	int checkEOF;
	while(1)
	{
		checkEOF = finFunction();

		if(checkEOF == 1)
			break;
	}

	return 0;
}
