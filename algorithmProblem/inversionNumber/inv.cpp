#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("inv.inp");
ofstream fout("inv.out");


int finNum[100000] = {0,};
int tmp[100000] = {0,};

long long result = 0;

clock_t start;
double end_t;

void init(int);
void foutFunction(int);
void merge(int,int);
void mergeFunction(int,int,int);

void foutFunction(int ln)
{
	fout<<result<<endl;
}

void merge(int start,int end)
{
	int mid = (start + end)/2;

	if(start < mid)
	{
		merge(start,mid);
		merge(mid,end);
		
		mergeFunction(start,mid,end);
	}

	return;
}

void mergeFunction(int start,int mid,int end)
{
	int tmpS = start,tmpM = mid, tmpE = end;
	int tmpIndex = 0;

	while(tmpS < mid && tmpM < end)
	{
		if(finNum[tmpS] < finNum[tmpM])
			tmp[tmpIndex++] = finNum[tmpS++];
		
		else if(finNum[tmpS] > finNum[tmpM])
		{
			tmp[tmpIndex++] = finNum[tmpM++];
			result += mid - tmpS;
		}
	}

	while(tmpS < mid)
		tmp[tmpIndex++] = finNum[tmpS++];

	while(tmpM < tmpE)
		tmp[tmpIndex++] = finNum[tmpM++];
	
	for(int i = 0;i < (end-start) ;i++)
		finNum[start + i] = tmp[i];

	return;
}

void init(int ln)
{
	result = 0;

	for(int i = 0;i < ln;i++)
		finNum[i] = 0;

	return;
}


int main()
{
	start = clock();

	int testCase,num,ln;

	fin>>testCase;
	while(testCase)
	{
		fin>>ln;

		for(int i = 0;i < ln;i++)
		{
			fin>>num;
			finNum[i] = num;
		}
		
		merge(0,ln);

		foutFunction(ln);

		init(ln);

		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<endl<<(double)(end_t-start)/CLOCKS_PER_SEC<<endl;
	return 0;
}
