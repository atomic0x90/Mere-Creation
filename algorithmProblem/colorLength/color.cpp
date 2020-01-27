#include <iostream>
#include <fstream>

#include <time.h>

#include <vector>

#include <cstring>

#include <cstdio>

#include <algorithm>
using namespace std;

ifstream fin("color.inp");
ofstream fout("color.out");

clock_t start_t;
double end_t;

int l1,l2;	//Line lenght
int testCase;
char *c1,*c2;

vector <char> mergel;

int checka[27];
int gap[5000][5000];

int minvalue;

string finString;
string finString2;

void finFunction();
int algo(int,int);
void init();
int sum();

void finFunction()
{
	getline(fin,finString);

	c1 = (char*)finString.c_str();

	getline(fin,finString2);

	c2 = (char*)finString2.c_str();

	cout<<c1<<endl;
	cout<<c2<<endl;

	l1 = strlen(c1);
	l2 = strlen(c2);

	for(int i = 0;i < l1;i++)
		checka[c1[i]-65]++;
	
	for(int i = 0;i < l2;i++)
		checka[c2[i]-65]++;

	mergel.reserve(l1+l2);

	return;
}

void init()
{
	memset(checka,0,sizeof(checka));
	memset(gap,-1,sizeof(gap));

	minvalue = 999999999;

	return;
}

int sum()
{
	int tmp[27];

	for(int i = 0;i < 27;i++)
	{
		if(checka[i] <= 1)
		{
			tmp[i] = 0;
			continue;
		}

		for(int j = mergel.size();j >= 0;j--)
		{
			if(mergel[j]-65 == i)
			{
				tmp[i] = j;
				break;
			}
		}
		for(int j = 0;j <= mergel.size();j++)
		{
			if(mergel[j]-65 == i)
			{
				tmp[i] -= j;
				break;
			}
		}
	}

	int re = 0;
	for(int i = 0;i < 27;i++)
	{
//		cout<<tmp[i]<<" ";

		re += tmp[i];
	}
//	cout<<endl;

	return re;
}

int algo(int start,int end)
{
//	cout<<start<<" "<<end<<" "<<gap[start][end]<<endl;

	if(gap[start][end] != -1)
		return gap[start][end];

	if(start == l1)
	{
		for(int i = end;i < l2;i++)
			mergel.push_back(c2[i]);

		for(int i = 0;i < mergel.size();i++)
			cout<<mergel[i]<<" ";
		cout<<endl;

		int re = sum();

//		cout<<"------------------ "<<re<<" ---------------"<<endl;

		for(int i = end;i < l2;i++)
			mergel.pop_back();

		return re;
	}
	
	if(end == l2)
	{
		for(int i = start;i < l2;i++)
			mergel.push_back(c1[i]);

		for(int i = 0;i < mergel.size();i++)
			cout<<mergel[i]<<" ";
		cout<<endl;

		int re = sum();

//		cout<<"------------------ "<<re<<" ---------------"<<endl;
		for(int i = start;i < l2;i++)
			mergel.pop_back();

		return re;
	}

	for(int i = start;i < l1;i++)
	{
		for(int j = start;j <= i;j++)
		       mergel.push_back(c1[j]);	

		if(gap[i][end] == -1)
		{
			gap[i][end] = algo(i+1,end);
			minvalue = gap[i][end];
		}
		else
		{
			gap[i][end] = min(gap[i][end], algo(i+1,end));
			if(minvalue > gap[i][end])
				minvalue = gap[i][end];
		}
		for(int j = start;j <= i;j++)
			mergel.pop_back();
	}

//	cout<<endl;

	for(int i = end;i < l2;i++)
	{
		for(int j = end;j <= i;j++)
			mergel.push_back(c2[j]);

		if(gap[start][i] == -1)
		{
			gap[start][i] = algo(start,i+1);
			minvalue = gap[start][i];
		}
		else
		{
			gap[start][i] = min(gap[start][i], algo(start,i+1));
			if(minvalue > gap[start][i])
				minvalue = gap[start][i];
		}
		for(int j = end;j <= i;j++)
			mergel.pop_back();
	}

	return gap[start][end];
}

int main()
{
	start_t = clock();

	string tests;

	getline(fin,tests);

	testCase = atoi(tests.c_str());

	while(testCase)
	{
		init();

		finFunction();

		cout<<algo(0,0)<<" "<<minvalue<<endl;

		fout<<minvalue<<endl;
		testCase--;
	}

	fin.close();
	fout.close();
	
	end_t = clock();
	cout<<(double)((end_t - start_t)/CLOCKS_PER_SEC)<<endl;

	return 0;
}
