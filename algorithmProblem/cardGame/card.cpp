#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

#define max(a,b) (a >= b ? a : b)
#define min(a,b) (a >= b ? b : a)

clock_t start_t;
double end_t;

int testCase;

int card[1001];
int front,rear;
int result;

int tmp[1001][1001];


ifstream fin("card.inp");
ofstream fout("card.out");

void finFunction();
void foutFunction();
int algo(int,int,int);
void init();

void init()
{
	result = 0;

	front = 1;



	for(int i = 0;i < 1001;i++)
	{
		card[i] = 0;
		for(int j = 0;j < 1001;j++)
			tmp[i][j] = 0;
	}

	return;
}

void finFunction()
{
	fin>>rear;

	for(int i = 1;i <= rear;i++)
		fin>>card[i];

	return;
}

//order % 2 == 1 : Alice
//order % 2 == 0 : Computer


int algo(int start,int end,int flag)
{
	if(tmp[start][end] != 0)
		return tmp[start][end];

	if(start == end)
	{
		if(flag % 2 == 1)
			return card[start];
		else
			return 0;
	}
	else
	{
		if(flag % 2 == 1)
		{
			tmp[start][end] = max( algo(start+1,end,flag+1) + card[start],algo(start,end-1,flag+1) + card[end] );
		}
		else
		{
			tmp[start][end] = min( algo(start+1,end,flag+1),algo(start,end-1,flag+1) );
		}
	}
	return tmp[start][end];
}

void foutFunction()
{
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

		result = algo(1,rear,1);

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();

	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;

	return 0;
}
