#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("cube.inp");
ofstream fout("cube.out");

clock_t start_t;
double end_t;

int testCase;

void finFunction();
void foutFunction();

int main()
{
	start_t = clock();

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
