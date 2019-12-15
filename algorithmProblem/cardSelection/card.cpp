#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("card.inp");
ofstream fout("card.out");

clock_t start_t;
double end_t;

int testCase;
int cardLength;
int cardLine[1001];

void finFunction();
void foutFunction();
void card();

void foutFunction()
{
	for(int i = 1;i <= cardLength;i++)
		cout<<cardLine[i]<<" ";

	cout<<endl;

	return;
}

void finFunction()
{
	fin>>cardLength;

	for(int i = 1;i <= cardLength;i++)
		fin>>cardLine[i];

	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		finFunction();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
