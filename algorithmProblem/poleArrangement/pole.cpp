#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("pole.inp");
ofstream fout("pole.out");

clock_t start_t;
double end_t;

long long pole[21][21][21];

void init();
void finFunction();
void foutFunction();
void algo();

int main()
{
	start_t = clock();



	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
