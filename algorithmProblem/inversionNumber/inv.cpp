#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("inv.inp");
ofstream fout("inv.out");


int checkInversion[100000] = {0,};
int finNum[100000] = {0,};

clock_t start;
double end_t;

void checkInversionNumber(int);
void init(int);
void foutFunction(int);

void foutFunction(int ln)
{
	long long sum = 0;
	for(int i = 0;i<ln;i++)
		sum += checkInversion[i];

	fout<<sum<<endl;

	return;
}

void checkInversionNumber(int ln)
{
	for(int i = 0;i<ln;i++)
	{
		for(int j = i;j < ln;j++)
		{
			if(finNum[i] > finNum[j])
				checkInversion[j]++;
		}
	}


	return;
}

void init(int ln)
{
	for(int i = 0;i<ln;i++)
	{
		checkInversion[i] = 0;
		finNum[i] = 0;
	}
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
		cout<<ln<<" ";

		checkInversionNumber(ln);

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
