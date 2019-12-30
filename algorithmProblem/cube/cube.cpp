#include <iostream>
#include <fstream>

#include <time.h>

#include <algorithm>

using namespace std;

ifstream fin("cube.inp");
ofstream fout("cube.out");

clock_t start_t;
double end_t;

int testCase;
int result;
int t1,t2,t3;
int cube[201][201][201];

void finFunction();
void foutFunction();
void init();
int algo(int,int,int);

void init()
{
	result = 0;
	for(int i = 0;i <= 200;i++)
	{
		for(int j = 0;j <= 200;j++)
		{
			for(int k = 0;k <= 200;k++)
				cube[i][j][k] = 999999;
		}
	}

	for(int i = 1;i < 201;i++)
		cube[i][i][i] = 1;

	return;
}

void finFunction()
{
	fin>>t1>>t2>>t3;

	if(t1 > t2)
		swap(t1,t2);
	if(t2 > t3)
		swap(t2,t3);
	if(t1 > t2)
		swap(t1,t2);

	return;
}

void foutFunction()
{
	fout<<result<<endl;

	return;
}

int algo(int w,int l,int h)
{
	if(w == l && l == h)
		return 1;

	if(w > l)
		swap(w,l);
	if(l > h)
		swap(l,h);
	if(w > l)
		swap(w,l);


	if(cube[w][l][h] != 999999)
		return cube[w][l][h];

	
	if(l == 1)
	{
		return cube[w][l][h] = h;
	}
	else if(w == 1)
	{
		return cube[w][l][h] = l*h;
	}
	else if(w == l && h % l == 0)
	{
		return cube[w][l][h] = h/l;
	}
	else
	{
		for(int i = 1;i <= w/2;i++)
			cube[w][l][h] = min( cube[w][l][h] , algo(i,l,h) + algo(w-i,l,h) );
		for(int i = 1;i <= l/2;i++)
			cube[w][l][h] = min( cube[w][l][h] , algo(w,i,h) + algo(w,l-i,h) );
		for(int i = 1;i <= h/2;i++)
			cube[w][l][h] = min( cube[w][l][h] , algo(w,l,i) + algo(w,l,h-i) );
	}

	return cube[w][l][h];
}

int main()
{
	start_t = clock();

	fin>>testCase;

	init();

	while(testCase)
	{
		finFunction();

		result = algo(t1,t2,t3);

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
