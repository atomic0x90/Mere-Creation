#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

clock_t start_t;
double end_t;

int testCase;

int card[1000];
int front,rear;
int result;

ifstream fin("card.inp");
ofstream fout("card.out");

void finFunction();
void foutFunction();
void algo();
void init();

void init()
{
	result = front = 0;

	for(int i = 0;i < 1000;i++)
		card[i] = 0;

	return;
}

void finFunction()
{

	return;
}

void algo()
{

	return;
}

void foutFunction()
{
	cout<<result<<endl;
	fout<<result<<endl;

	return;
}

int main()
{
	start_t = clock();

	fin>>testCase;

	while(testCase)
	{
		init();

		finFunction();
	
		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();

	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;

	return 0;
}
