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
		return 1;


	return 0;
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
