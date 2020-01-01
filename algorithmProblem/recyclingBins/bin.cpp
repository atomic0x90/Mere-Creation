#include <iostream>
#include <fstream>

#include <time.h>

#include <algorithm>

using namespace std;

ifstream fin("bin.inp");
ofstream fout("bin.out");

clock_t start_t;
double end_t;

int testCase;

int home,bin;
int coor[500];

void init();
void finFunction();
void foutFunction();


void finFunction()
{
	fin>>home>>bin;

	for(int i = 1;i <= home;i++)
		fin>>coor[i];

	sort(coor,coor+home+1);

	for(int i = 1;i <= home;i++)
                cout<<coor[i]<<" ";
        cout<<endl;

	return;
}

int main()
{
	start_t = clock();

	fin>>testCase;

	while(testCase)
	{
		finFunction();
	
		testCase--;
	}

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
