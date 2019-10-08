#include <iostream>
#include <fstream>

#include <cstring>

using namespace std;

ifstream fin("cube.inp");
ofstream fout("cube.out");

string finString;

char *splitString;
char firstCube[7];
char secondCube[7];

int finFunction();
void foutFunction(int);
int checkPainting();
int checkEOFFunction();
void cubeSpin(int);

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
	int check = 0,tmp,tmp2;

	firstCube[0] = secondCube[0] = ' ';

	for(int i = 0;i < 6;i++)
	{
		firstCube[i+1] = splitString[i];
		secondCube[i+1] = splitString[6+i];
	}

	for(int i = 1; i < 7;i++)
	{
		if(firstCube[1] == secondCube[i] && firstCube[6] == secondCube[7-i])
		{
			check = i;
			break;
		}
	}

	if(check == 0)
		return 0;
	else
		cubeSpin(check);

	return 0;
}

void cubeSpin(int check)
{
	int tmp1,tmp2;

	if(check == 1)
		return;
/*	else if(check == 2)
	{
		tmp1 = secondCube[2];
		tmp2 = secondCube[5];

		secondCube[2] = secondCube[6];
		secondCube[5] = secondCube[1];

		secondCube[6] = tmp2;
		secondCube[1] = tmp1;
	}
	else if(check == 3)
	{
		tmp1 = secondCube[3];
		tmp2 = secondCube[4];

		secondCube[3] = secondCube[6];
		secondCube[4] = secondCube[1];

		secondCube[6] = tmp2;
		secondCube[1] = tmp1;
	}
	else if(check == 4)
	{
		tmp1 = secondCube[4];
		tmp2 = secondCube[3];

		secondCube[4] = secondCube[6];
		secondCube[3] = secondCube[1];

		secondCube[6] = tmp2;
		secondCube[1] = tmp1;
	}
	else if(check == 5)
	{
		tmp1 = secondCube[5];
		tmp2 = secondCube[2];

		5 = 6;
		2 = 1;
	}*/
	else if(check == 6)
	{
		tmp1 = secondCube[6];
		tmp2 = secondCube[1];

		secondCube[6] = tmp2;
		secondCube[1] = tmp1;

		tmp1 = secondCube[3];
		tmp2 = secondCube[4];

		secondCube[3] = tmp2;
		secondCube[4] = tmp1;
	}
	else
	{
		tmp1 = secondCube[check];
		tmp2 = secondCube[7-check];

		secondCube[check] = secondCube[6];
		secondCube[7-check] = secondCube[1];

		secondCube[6] = tmp2;
		secondCube[1] = tmp1;
	}
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
