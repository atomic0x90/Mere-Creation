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


//	sort(block.begin(),block.end(),ycompare);

	/*
	for(int i = 0;i < block.size();i++)
	{
		cout<<block[i].first.first<<" "<<block[i].first.second<<" "<<block[i].second.first<<" "<<block[i].second.second<<endl;
	}
*/

	return;
}

void algo()
{
	while(1)
	{
		int flag = 0;

		int x1,x2,y1,y2;

		sort(block.begin(),block.end(),ycompare);

		for(int i = 0;i < block.size();i++)
		{
			if(block[i].second.first == 0)
				continue;

			x1 = block[i].first.first;
			x2 = block[i].first.second;
			y1 = block[i].second.first;
			y2 = block[i].second.second;

			int check = y1;

			for(int j = 0;j < i;j++)
			{
				if((x1 <= block[j].first.first && x2 >= block[j].first.second) || (x1 >= block[j].first.first && x1 < block[j].first.second) || (x2 > block[j].first.first && x2 <= block[j].first.second) )
				{
//					cout<<"a "<<x1<<" "<<x2<<" "<<y1<<" "<<y2<<endl;

					if(y1 - block[j].second.second < check && y1 >= block[j].second.second)
						check = y1 - block[j].second.second;
				}
			}
		
			if(check)
			{
//				cout<<"Y "<<block[i].second.first<<" "<<block[i].second.second<<" "<<check<<endl;
				block[i].second.first -= check;
				block[i].second.second -= check;
				
				flag++;
			}

		}

		sort(block.begin(),block.end(),xcompare);

		for(int i = 0;i < block.size();i++)
		{
			if(block[i].first.first == 0)
				continue;

			x1 = block[i].first.first;
			x2 = block[i].first.second;
			y1 = block[i].second.first;
			y2 = block[i].second.second;

			int check = x1;

			for(int j = 0;j < i;j++)
			{
				if((y1 <= block[j].second.first && y2 >= block[j].second.second)|| (y1 >= block[j].second.first && y1 < block[j].second.second) || (y2 > block[j].second.first && y2 <= block[j].second.second))
				{
//					cout<<"b "<<x1<<" "<<x2<<" "<<y1<<" "<<y2<<endl;

					if(x1 - block[j].first.second < check && x1 >= block[j].first.second)
						check = x1 - block[j].first.second;
				}
			}

			if(check)
			{
//				cout<<"X "<<block[i].first.first<<" "<<block[i].first.second<<" "<<check<<endl;
				block[i].first.first -= check;
				block[i].first.second -= check;
			
				flag++;
			}
		}


	
		if(!flag)
			break;
	}

	int maxX,maxY;
	maxX = maxY = 0;
	for(int i = 0;i < block.size();i++)
	{
		if(block[i].first.second > maxX)
			maxX = block[i].first.second;
		if(block[i].second.second > maxY)
			maxY = block[i].second.second;
	}

	fout<<maxX<<" "<<maxY<<endl;

//	cout<<endl;

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
