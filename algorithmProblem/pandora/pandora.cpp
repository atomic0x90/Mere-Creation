#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

clock_t start_t;
double end_t;

void finFunction();
void foutFunction();
void pandora();

int main()
{
	start_t = clock();

	end_t = clock();
	cout<<endl<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;

	return 0;
}
