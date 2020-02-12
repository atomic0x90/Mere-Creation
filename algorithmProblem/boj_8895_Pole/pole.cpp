#include <iostream>

using namespace std;

long long pole[21][21][21] = {0,};

int testCase;
int n,l,r;

void finFunction();
void foutFunction();
void algo();

void finFunction()
{
	cin>>n>>l>>r;

	return;
}

void foutFunction()
{
	cout<<pole[n][l][r]<<endl;

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
	

	algo();

	cin>>testCase;
	
	while(testCase)
	{
		finFunction();


		foutFunction();

		testCase--;
	}


	
	return 0;
}
