#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("coin.inp");
ofstream fout("coin.out");

clock_t start_t;
double end_t;

int testCase;
int coin1[1001],coin2[1001],coin3[1001];

void init();
void finFunction();
void foutFunction();
int algo(int,int,int);

int main()
{
	start_t = clock();


	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
