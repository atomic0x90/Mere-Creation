#include <iostream>
#include <fstream>

#include <vector>
#include <utility>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

vector < pair <int,int> > xCoordinates;
vector < pair <int,int> > yCoordinates;

vector <int> invisibleDegree;

int testCase;


void vectorSet();
void finFunction();
void verifyOverlapFunction(int,int,int,int,int);
void foutFunction();

void vectorSet()
{
	xCoordinates.reserve(testCase);
	yCoordinates.reserve(testCase);
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
		
		xCoordinates[i].first = x;
		xCoordinates[i].second = x + w;

		yCoordinates[i].first = y;
		yCoordinates[i].second = y + h;

		invisibleDegree[i] = 0;

		if(i)
			verifyOverlapFunction(i,x,x+w,y,y+h);

		i++;
		testCase--;
	}
	
	return ;
}

void verifyOverlapFunction(int value,int x,int w,int y,int h)
{
	int i = 0, j = value;

	for(; i < j ; i++)
	{
		if(invisibleDegree[i] != 2)
		{
			if( (xCoordinates[i].first > x && xCoordinates[i].second < w))
			{}
		}
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
