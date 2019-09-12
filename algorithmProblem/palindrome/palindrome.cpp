#include <iostream>
#include <fstream>
#include <string>


using namespace std;

ifstream fin("palindrome.inp");
ofstream fout("palindrome.out");

int testCase,checkNumber;

string finString;
char *stringSplit;

void finFunction();
void foutFunction(int);
int palindromeCheckFunction(char *);

void finFunction()
{

	checkNumber = palindromeCheckFunction(char *stringSplit);


	return;
}

int palindromeCheckFunction(char *value)
{
	
	return;
}

void foutFuntion(int result)
{

	return;
}

int main()
{
	fin >> testCase;

	while(testCase > 0)
	{
		finFunction();
	
		testCase--;
	}

	return 0;
}
