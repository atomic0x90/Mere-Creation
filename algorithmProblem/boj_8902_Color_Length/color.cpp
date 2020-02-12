#include <iostream>
#include <cstring>	//strlen

#include <algorithm>	//min

using namespace std;

int l1,l2;	//Line lenght
int testCase;
char *c1,*c2;

int check1[5002][27],check2[5002][27];

int gap[5002][5002];

string finString;
string finString2;

void finFunction();
int algo();
void init();
void sum();
int checkmin(int,int,int);

void finFunction()
{
	getline(cin,finString);

	c1 = (char*)finString.c_str();

	getline(cin,finString2);

	c2 = (char*)finString2.c_str();

	l1 = strlen(c1);
	l2 = strlen(c2);

	return;
}

void init()
{
	memset(gap,999999,sizeof(gap));
	memset(check1,0,sizeof(check1));
	memset(check2,0,sizeof(check2));

	return;
}

int checkmin(int x1,int x2,int ap)
{
	int re = 0;

	if(check1[x1][ap] + check2[x2][ap] == check1[l1][ap] + check2[l2][ap])
	{	//The last car of this color
		re += x1 + x2;
	}
	if(check1[x1][ap] + check2[x2][ap] == 1)
	{	//The first car of this color
		re -= x1 + x2;
	}

	return re;
}

void sum()
{
	gap[0][0] = 0;

	for(int i = 0;i <= l1;i++)
	{
		for(int j = 0;j <= l2;j++)
		{
			if(i > 0)
				gap[i][j] = min(gap[i-1][j] + checkmin(i,j,c1[i-1]-65), gap[i][j]);
		
			if(j > 0)
				gap[i][j] = min(gap[i][j-1] + checkmin(i,j,c2[j-1]-65), gap[i][j]);
		
		}
	}

	return;
}

int algo()
{
	for(int i = 1;i <= l1;i++)
	{
		check1[i][c1[i-1]-65]++;

		for(int j = 0;j < 26;j++)
			check1[i+1][j] = check1[i][j];
	}

	for(int i = 1;i <= l2;i++)
	{
		check2[i][c2[i-1]-65]++;

		for(int j = 0;j < 26;j++)
			check2[i+1][j] = check2[i][j];
	}

	sum();

	return gap[l1][l2];
}

int main()
{
	string tests;

	getline(cin,tests);

	testCase = atoi(tests.c_str());

	while(testCase)
	{
		init();

		finFunction();

		cout<<algo()<<endl;

		testCase--;
	}

	return 0;
}
