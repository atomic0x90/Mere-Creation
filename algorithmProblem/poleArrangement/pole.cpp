#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("pole.inp");
ofstream fout("pole.out");

clock_t start_t;
double end_t;

long long pole[21][21][21] = {0,};

int testCase;
int n,l,r;

void finFunction();
void foutFunction();
void algo();

void finFunction()
{
	fin>>n>>l>>r;

	return;
}

void foutFunction()
{
	cout<<pole[n][l][r]<<endl;
	fout<<pole[n][l][r]<<endl;

	return;
}

void algo()
{
	pole[1][1][1] = 1;

	for(int i = 2;i <= 20;i++)
	{
		for(int j = 1;j <= 20;j++)
		{
			for(int k = 1;k <= 20;k++)
			{
				pole[i][j][k] = pole[i-1][j-1][k] + pole[i-1][j][k-1] + ( (i-2) * pole[i-1][j][k] );
			}
		}
	}

	return;
}

int main()
{
	start_t = clock();

	algo();

	fin>>testCase;
	
	while(testCase)
	{
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
