#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("go.inp");
ofstream fout("go.out");

clock_t start_t;
double end_t;

char finGo[20][20] = {' ',};

void finFunction();
void foutFunction(int,int);
void go(int,int);

int main()
{
	start_t = clock();

	fin.close();
	fout.close();

	end_t = clock();
	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
