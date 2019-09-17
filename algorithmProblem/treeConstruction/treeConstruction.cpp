#include <iostream>
#include <fstream>

#include <cstring>

using namespace std;

ifstream fin("tree.inp");
ofstream fout("tree.out");

int testCase, checkLength;

string finString;

char *splitString;

void finFunction();
void foutFunction();
void treeConstruction();

void finFunction()
{
	getline(fin,finString);

	splitString = (char *)finString.c_str();
	
	checkLength = strlen(splitString);

	cout<<checkLength<<endl;

	return;
}

void treeConstruction()
{

	return;
}

void foutFunction()
{

	return;
}

int main()
{
	fin >> testCase;


	while(testCase >= 0)
	{
		finFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
