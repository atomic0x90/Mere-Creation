#include <iostream>
#include <fstream>


using namespace std;

ifstream fin("bitmap.inp");
ofstream fout("bitmap.out");

char finChar;
char row[200],column[200];
int rowSize,columnSize;
char type;

void finFunction();
void foutFunction();
void Btype();
void Dtype();

int main()
{
	fin.close();
	fout.close();

	return 0;
}
