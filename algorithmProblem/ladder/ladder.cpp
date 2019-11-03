#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

clock_t start_t;
double end_t;

ifstream fin("ladder.inp");
ofstream fout("ladder.out");

int start[50][10000] = {0,};
int arrival[50][10000] = {0,};

void finFunction();
void foutFunction();
void sortFunction();
void ladder();


int main()
{
	start_t = clock();


	fin.close();
	fout.close();

	end_t = clock();

	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
