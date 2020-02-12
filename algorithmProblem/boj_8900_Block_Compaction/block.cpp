#include <iostream>
#include <vector>

#include <utility>

#include <algorithm>
using namespace std;

int testCase;
int num;

vector < pair< pair<int,int> , pair<int,int> > > block;	//x,x+a,y,y+b

void finFunction();
void algo();

bool xcompare(const pair< pair<int,int> , pair<int,int> > &a,const pair< pair<int,int> , pair<int,int> > &b)
{
	if(a.first.first != b.first.first)
		return a.first.first < b.first.first;
	else
		return a.second.first < b.second.first;
}

bool ycompare(const pair< pair<int,int> , pair<int,int> > &a,const pair< pair<int,int> , pair<int,int> > &b)
{
	if(a.second.first != b.second.first)
		return a.second.first < b.second.first;
	else
		return a.first.first < b.first.first;
}

void finFunction()
{
	cin>>num;

	block.reserve(num);

	int x1,x2,y1,y2;
	while(num)
	{
		cin>>x1>>y1>>x2>>y2;

		block.push_back({{x1,x2},{y1,y2}});
	
		num--;
	}

	return;
}

void algo()
{
	while(1)
	{
		int flag = 0;

		sort(block.begin(),block.end(),ycompare);

		for(int i = 0;i < block.size();i++)
		{
			if(block[i].second.first == 0)
				continue;
			
			int check = 0;
			for(int j = 0;j < i;j++)
			{
				if(block[i].first.first < block[j].first.second && block[i].first.second > block[j].first.first)
				{
					if(check < block[j].second.second)
						check = block[j].second.second;
				}
			}

			int tmp = block[i].second.first - check;

			block[i].second.first -= tmp;
			block[i].second.second -= tmp;

			if(tmp)
				flag++;

		}

		sort(block.begin(),block.end(),xcompare);

		for(int i = 0;i < block.size();i++)
		{
			if(block[i].first.first == 0)
				continue;

			int check = 0;

			for(int j = 0;j < i;j++)
			{
				if(block[i].second.first < block[j].second.second && block[i].second.second > block[j].second.first)
				{
					if(check < block[j].first.second)
						check = block[j].first.second;
				}
			}

			int tmp = block[i].first.first - check;

			block[i].first.first -= tmp;
			block[i].first.second -= tmp;

			if(tmp)
				flag++;
		}


	
		if(!flag)
			break;
	}

	int maxX,maxY;

	maxX = maxY = 0;
	for(int i = 0;i < block.size();i++)
	{
		if(maxX < block[i].first.second)
			maxX = block[i].first.second;
		if(maxY < block[i].second.second)
			maxY = block[i].second.second;
	}

	cout<<maxX<<" "<<maxY<<endl;

	block.clear();

	return;
}

int main()
{
	cin>>testCase;

	while(testCase)
	{
		finFunction();

		algo();

		testCase--;
	}

	return 0;
}
