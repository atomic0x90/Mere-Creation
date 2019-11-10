#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("go.inp");
ofstream fout("go.out");

clock_t start_t;
double end_t;

int size;

char finGo[21][21];

void finFunction();
void foutFunction();
void go();
void xaxis(int,int);
void yaxis(int,int);

void finFunction()
{
	fin>>size;

	char tmp;
	for(int i = 1;i <= size;i++)
	{
		for(int j = 1;j <= size;j++)
		{
			fin>>tmp;

			finGo[i][j] = tmp;
			cout<<finGo[i][j];
		}
		cout<<endl;
	}

	return;
}

void xaxis(int x,int f,int s)
{
	cout<<f<<" "<<s<<endl;

	if(f == s)
		return;
	else
	{
		if(finGo[x][f] == '.')
		{
			for(int i = f;i < s;i++)
			{
				if(finGo[x][s] == 'B')
					finGo[x][i] = 'b';
				else
					finGo[x][i] = 'w';
			}
		}
		else if( (finGo[x][f] == 'B' && finGo[x][s] == 'W') || (finGo[x][f] == 'W' && finGo[x][s] == 'B') )
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'x';
		}
		else if(finGo[x][f] == 'B' && finGo[x][s] == 'B')
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'b';
		}
		else if(finGo[x][f] == 'W' && finGo[x][s] == 'W')
		{
			for(int i = f+1;i < s;i++)
				finGo[x][i] = 'w';
		}
		else if(finGo[x][s] == '.')
		{
			for(int i = s;i > f;i--)
			{
				if(finGo[x][f] == 'B')
					finGo[x][i] = 'b';
				else
					finGo[x][i] = 'w';
			}
		}
	}

	return;
}

void go()
{
	int t1,t2;

	for(int i = 1;i <= size;i++)
	{
		t1 = t2 = 1;
		for(int j = 1;j <= size;j++)
		{
			if(finGo[i][j] == 'B' || finGo[i][j] == 'W')
			{
				t2 = j;
				
				xaxis(i,t1,t2);
			
				t1 = t2;
			}
		}

		t1 = t2 = size;
		for(int j = size;j > 0;j--)
		{
			if(finGo[i][j] == 'B' || finGo[i][j] == 'W')
			{
				t1 = j;

				xaxis(i,t1,t2);

				t2 = t1;
			}
		}
		cout<<endl;
	}
	
	return;
}

int main()
{
	start_t = clock();

	finFunction();


	go();


	fin.close();
	fout.close();

	end_t = clock();
	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
