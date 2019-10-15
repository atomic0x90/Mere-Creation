#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("inv.inp");
ofstream fout("inv.out");

int checkInversion[100000] = {0,};
int finNum[100000] = {0,};

void checkInversionNumber();

int main()
{
	int testCase,ln,num;

	fin>>testCase;
	while(testCase)
	{
		fin>>ln;

		for(int i = 0;i < ln;i++)
		{
			fin>>num;
			finNum[i] = num;
		}
		cout<<ln<<" ";

	
		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
