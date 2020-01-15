#include <iostream>
#include <fstream>

#include <time.h>

//#include <stdlib.h>	//abs

#include <algorithm>

#include <cstring>	//memset

using namespace std;

ifstream fin("bin.inp");
ofstream fout("bin.out");

clock_t start_t;
double end_t;

int testCase;

int home,bin;

int coor[501];

int bin1[501][501];
int sum[501][501];

void init();
void finFunction();
void foutFunction();
int algo();

int split(int,int);	//start, remaining bins

void finFunction()
{
	fin>>home>>bin;

	cout<<home<<" "<<bin<<endl;

	for(int i = 1;i <= home;i++)
		fin>>coor[i];

	sort(coor,coor+home+1);

	for(int i = 1;i <= home;i++)
                cout<<coor[i]<<" ";
        cout<<endl;

	return;
}

int algo()
{
	for(int i = 1;i <= home;i++)
	{
		for(int j = i;j <= home;j++)
		{
			bin1[i][j] = bin1[i][j-1] + coor[j] - coor[i + ((j-i)/2)];

			cout<<bin1[i][j]<<" ";
		}
		cout<<endl;
	}
}

void init()
{
	memset(bin1,0,sizeof(bin1));
	memset(sum,0,sizeof(sum));

	return;
}

int main()
{
	start_t = clock();

	fin>>testCase;

	while(testCase)
	{
		finFunction();
	
		init();

		algo();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
