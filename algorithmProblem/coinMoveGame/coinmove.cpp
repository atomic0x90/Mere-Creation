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
int coin[1000000][8];

int save;
void finFunction();
void foutFunction();
void init();
int algo();

void finFunction()
{
	fin>>P>>K>>S;

	return;
}

void init()
{
	save = 0;
	result = -1;
	for(int i = 0;i <= S;i++)
	{
		for(int j = 1;j < 8;j++)
			coin[i][j] = 0;
	}

	return;
}

void foutFunction()
{
	fout<<result<<endl;

	return;
}

int algo()
{
	for(int i = 1;i <= K;i++)
		coin[0][i] = -1;

	for(int i = 1;i <= S;i++)
	{
		for(int j = 1;j <= K;j++)
		{
			for(int l = 1;l <= K;l++)
			{
				if(j != l)
				{
					if( ( (i-j) % P == 0 && i-j != 0 ) || coin[i-j][l] == 1 || j > i)
					{
						coin[i][j] = -1;
						break;
					}
				}
				else
					continue;
			}

			if(coin[i][j] == 0)
				coin[i][j] = 1;
		}
	}

	for(int i = 1;i <= K;i++)
	{
		if(coin[S][i] == 1)
			return S-i;
	}

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
		
		result = algo();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
