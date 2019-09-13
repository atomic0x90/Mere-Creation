#include <iostream>
#include <fstream>
//#include <vector>
#include <cstring>	//strlen()


using namespace std;

ifstream fin("palindrome.inp");
ofstream fout("palindrome.out");

int testCase, checkNumber;

string finString;

char *splitString;

/*
char finValue;

vector <char>finString;
*/

void finFunction();
void foutFunction(int);
int palindromeCheckFunction(char *);

void finFunction()
{
	getline(fin,finString);

	splitString = (char *)finString.c_str();
	
	cout<<*splitString<<" "<<strlen(splitString)<<endl;

	checkNumber = palindromeCheckFunction(splitString);

	return;
}

int palindromeCheckFunction(char *value)
{
	int i = 0, j = strlen(value);
	
	return 0;
}

void foutFuntion(int result)
{

	return;
}

int main()
{
	fin >> testCase;

	while(testCase >= 0)
	{
		cout<<testCase;
		finFunction();
	
		testCase--;
	}

	return 0;
}
