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
void verifyOverlapFunction(int);
void foutFunction();

void vectorSet()
{
	xAxisCoordinates.reserve(testCase);
	yAxisCoordinates.reserve(testCase);
	invisibleDegree.reserve(testCase);

	return ;
}

void finFunction()
{
	int x,y,w,h;
	int i = 0;
	
	while(testCase)
	{
		fin >> x >> y >> w >> h;
		
		xAxisCoordinates[i].first = x;
		xAxisCoordinates[i].second = x + w;

		yAxisCoordinates[i].first = y;
		yAxisCoordinates[i].second = y + h;

		invisibleDegree[i] = 0;

		if(i)
			verifyOverlapFunction(i);

		i++;
		testCase--;
	}
	
	return ;
}

void verifyOverlapFunction(int value)
{
	int i = 0;

	while(value)
	{
	
		value--;
	}

	return ;
}

int main()
{
	fin >> testCase;

	cout<<testCase<<endl;

	vectorSet();	

	finFunction();



	fin.close();
	fout.close();

	return 0;
}
