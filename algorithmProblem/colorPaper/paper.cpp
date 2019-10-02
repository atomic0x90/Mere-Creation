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
	xCoordinates.reserve(testCase * 2);
	yCoordinates.reserve(testCase * 2);
	invisibleDegree.reserve(testCase * 2);

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

	for(int j = 0 ; j < i ; j++)
		cout<< invisibleDegree[j]<<endl;
	
	return ;
}

void verifyOverlapFunction(int value,int x,int w,int y,int h)
{
	int i = 0, j = value;

	for(; i < j ; i++)
	{
		bool xF = xCoordinates[i].first < x;	//입력된 x 좌표가 이미 있는 좌표보다 큰 경우 1
		bool xFC = xCoordinates[i].first == x;	//x 좌표가 같은 경우 1
		bool xS = xCoordinates[i].second < w;	//입력된 x+w 좌표가 이미 있는 좌표보다 큰 경우 1
		bool xSC = xCoordinates[i].second == w;	//x+w 좌표가 같은 경우 1
		bool yF = yCoordinates[i].first < y;
		bool yFC = yCoordinates[i].first == y;
		bool yS = yCoordinates[i].second < h;
		bool ySC = yCoordinates[i].second == h;
		cout<<x<<" "<<w<<" "<<y<<" "<<h<<" "<<xF<<endl;
		if(invisibleDegree[i] != 2)
		{
			if((!xF || xFC) && (!yF || yFC) && (xS || XSC) && (yS || ySC))
			{	//아예 덮을때
				invisibleDegree[i] = 2;
			}
			else if( (xCoordinates[i].first >= x && xCoordinates[i].second >= w) )
			{}
		}
	}cout<<endl;

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
