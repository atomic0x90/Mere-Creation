#include <iostream>
#include <fstream>

#include <vector>
#include <utility>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

vector < pair <int,int> > xAxisCoordinates;
vector < pair <int,int> > yAxisCoordinates;

vector <int> invisibleDegree;

int testCase;


void vectorSet();
void finFunction();
void verifyOverlapFunction();
void foutFunction();

void vectorSet()
{
	xAxisCoordinates.reserve(testCase);
	yAxisCoordinates.reserve(testCase);
	invisibleDegree.reserve(testCase);

	return ;
}

int main()
{
	fin >> testCase;

	cout<<testCase<<endl;

	vectorSet();	

	cout<<xAxisCoordinates.size()<<" "<<yAxisCoordinates.size()<<" "<<invisibleDegree.size()<<endl;

	while(testCase)
	{
		
		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
