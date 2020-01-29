#include <iostream>
#include <fstream>

#include <time.h>

#include <vector>

#include <utility>

#include <algorithm>
using namespace std;

ifstream fin("block.inp");
ofstream fout("block.out");

clock_t start_t;
double end_t;

int testCase;
int num;

vector < pair< pair<int,int> , pair<int,int> > > block;	//x,x+a,y,y+b

void finFunction();
void algo();

bool xcompare(const pair< pair<int,int> , pair<int,int> > &a,const pair< pair<int,int> , pair<int,int> > &b)
{
	return a.first.first < b.first.first;
}

bool ycompare(const pair< pair<int,int> , pair<int,int> > &a,const pair< pair<int,int> , pair<int,int> > &b)
{
	return a.second.first < b.second.first;
}

void finFunction()
{
	fin>>num;

	block.reserve(num);

	int x1,x2,y1,y2;
	while(num)
	{
		fin>>x1>>y1>>x2>>y2;

		block.push_back({{x1,x2},{y1,y2}});
	
		num--;
	}


	sort(block.begin(),block.end(),ycompare);

	for(int i = 0;i < block.size();i++)
	{
		cout<<block[i].first.first<<" "<<block[i].first.second<<" "<<block[i].second.first<<" "<<block[i].second.second<<endl;
	}


	return;
}

void algo()
{


	block.clear();

	return;
}

int main()
{
	start_t = clock();

	fin>>testCase;

	while(testCase)
	{
		finFunction();

		algo();

		testCase--;
	}

	fin.close();
	fout.close();
	end_t = clock();
	cout<<(double)((end_t - start_t)/CLOCKS_PER_SEC)<<endl;
	return 0;
}
