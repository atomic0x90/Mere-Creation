#include <iostream>
#include <fstream>

#include <time.h>

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
int algo();
int slove(int,int);

void finFunction()
{
	fin>>home>>bin;

	for(int i = 1;i <= home;i++)
		fin>>coor[i];

	sort(coor,coor+home+1);

	return;
}

int algo()
{
	for(int i = 1;i <= home;i++)
	{
		for(int j = i;j <= home;j++)
			bin1[i][j] = bin1[i][j-1] + coor[j] - coor[i + ((j-i)/2)];
	}

	return slove(1,bin);
}

int slove(int st,int b)
{
	if(st > home)
	{
		if(b == 0)
			return 0;
		else
			return 9999999;
	}
	if(b == 0)
		return 9999999;

	if(sum[st][b] != -1)
		return sum[st][b];

	for(int i = st;i <= home;i++)
	{
		if(sum[st][b] == -1)
			sum[st][b] = slove(i+1,b-1) + bin1[st][i];
		else
			sum[st][b] = min(sum[st][b], slove(i+1,b-1) + bin1[st][i]);
	}

	return sum[st][b];
}

void init()
{
	memset(bin1,0,sizeof(bin1));
	memset(sum,-1,sizeof(sum));

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

		fout<<algo()<<endl;

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
