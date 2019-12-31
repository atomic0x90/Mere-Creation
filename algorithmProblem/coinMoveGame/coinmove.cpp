#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("coinmove.inp");
ofstream fout("coinmove.out");

clock_t start_t;
double end_t;

int P,K,S;
int result;
int testCase;
int coin[8][1000000];

void finFunction();
void foutFunction();
void init();
int algo(int,int);

void finFunction()
{
	fin>>P>>K>>S;

	return;
}

void init()
{
	result = -1;
	for(int i = 0;i < 8;i++)
	{
		for(int j = 0;j <= S;j++)
			coin[i][j] = 0;
	}

	return;
}

void foutFunction()
{
	cout<<result<<endl;
	fout<<result<<endl;

	return;
}

int algo(int lastmove,int now)
{
	if(now < 0)
		return -1;

	if(coin[lastmove][now] != 0)
		return coin[lastmove][now];

	return -1;
}

int main()
{
	start_t = clock();

	fin>>testCase;
	while(testCase)
	{
		finFunction();

		init();
	
		result = algo(0,S);

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
