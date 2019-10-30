#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

int testCase;
int x[2000] = {0,},y[2000] = {0,},xx[2000] = {0,},yy[2000] = {0,};
int checkOL[2000] = {0,};
int tx[2000] = {0,},ty[2000] = {0,},txx[2000] = {0,},tyy[2000] = {0,};

int tmpx[2000] = {0,},tmpy[2000] = {0,},tmpxx[2000] = {0,},tmpyy[2000] = {0,};

int ti = 0;

void finFunction();
void overlapCheck();
void merge();
void foutFunction();

void overlapCheck()
{
	int tmp = testCase-1;

	for(int i = tmp;i >= 0;i--)
	{	//전체
		int tmpv = 1;
		tmpx[0] = x[i],tmpy[0] = y[i],tmpxx[0] = xx[i],tmpyy[0] = yy[i];

		for(int j = 0;j < tmpv;j++)
		{	//나눠졌을 경우
			for(int k = 0;k < ti;k++)
			{	//tx 검사
	//			cout<<x[i]<<" "<<y[i]<<" "<<xx[i]<<" "<<yy[i]<<endl;
				if(tmpx[j] >= tx[k] && tmpxx[j]<= txx[k] && tmpy[j] >= ty[k] && tmpyy[j] <= tyy[k])
				{	//전부 덮일경우
					tmpx[j] = 0;
					tmpxx[j] = 0;
					tmpy[j] = 0;
					tmpyy[j] = 0;

					checkOL[i] = 2;
				}
			}
		}
		for(int j = 0;j < tmpv;j++)
		{
			if(tmpxx[j] - tmpx[j] > 0)
			{
				tx[ti] = tmpx[j];
				txx[ti] = tmpxx[j];
				ty[ti] = tmpy[j];
				tyy[ti] = tmpyy[j];

				ti++;
			}
		}
		merge();
	}
}

void merge()
{}

void finFunction()
{
	fin>>testCase;

	int t1,t2,t3,t4;
	int i = 0,tmp = testCase;

	while(tmp)
	{
		fin>>t1>>t2>>t3>>t4;

		x[i] = t1;
		y[i] = t2;
		xx[i] = t1 + t3;
		yy[i] = t2 + t4;
	
		i++;
		tmp--;
	}

	return;
}

void foutFunction()
{
	int t0,t1,t2;
	t0 = t1 = t2 = 0;

	for(int i = 0;i < testCase;i++)
	{
		if(checkOL[i] == 0)
			t0++;
		else if(checkOL[i] == 1)
			t1++;
		else
			t2++;
	}
	cout<<t2<<" "<<t1<<" "<<t0<<endl;

	return;
}

int main()
{
	finFunction();

	overlapCheck();

	foutFunction();
	return 0;
}
