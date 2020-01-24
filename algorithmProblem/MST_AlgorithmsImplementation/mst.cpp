#include <iostream>
#include <fstream>

#include <vector>
#include <utility>
#include <algorithm>

#include <time.h>

#include <cstring>

using namespace std;

ifstream fin("mst.inp");
ofstream fout("mst.out");

clock_t start_t;
double end_t;

vector < pair < pair<int,int> , pair<int,int> > > v;

vector <int> save;

int visit[10001];

int vertex,edge;
int sum;

void finFunction();
void prim(int);
void kruskal();
void sortFunction();

int find(int);
void unionParent(int,int);
bool checkParent(int,int);

int find(int x)
{
	if(visit[x] == x)
		return x;

	return visit[x] = find(visit[x]);
}

void unionParent(int x,int y)
{
	int p1,p2;

	p1 = find(x);
	p2 = find(y);

	if(p1 == p2)
		return;

	if(p1 < p2)
	{
		for(int i = 0;i < vertex;i++)
		{
			if(visit[i] == visit[y])
				visit[i] = p1;
		}

		visit[y] = p1;
	}
	else
	{
		for(int i = 0;i < vertex;i++)
		{
			if(visit[i] == visit[x])
				visit[i] = p2;
		}

		visit[x] = p2;
	}

	return;
}

bool checkParent(int x,int y)
{
	int p1,p2;

	p1 = find(x);
	p2 = find(y);

	if(p1 == p2)
		return true;
	else
		return false;

}

void sortFunction()
{
	sort(v.begin(),v.end());
	
	return;
}

void finFunction()
{
	fin>>vertex>>edge;

	v.reserve(edge);
	save.reserve(edge);

	int t1,t2,t3;
	for(int i = 0;i < edge;i++)
	{
		fin>>t1>>t2>>t3;

		v.push_back({{t3,i},{t1,t2}});
	}

	return;
}

void kruskal()
{
	sum = 0;

	for(int i = 0;i < vertex;i++)
		visit[i] = i;

	for(int i = 0;i < edge;i++)
	{
		if( !checkParent(v[i].second.first , v[i].second.second) )
		{
			sum += v[i].first.first;
			save.push_back(v[i].first.second);
			unionParent(v[i].second.first, v[i].second.second);
		}
	}

	fout<<"Tree edges by Kruskal algorithm: "<<sum<<endl;
	for(int i = 0;i < save.size();i++)
		fout<<save[i]<<endl;

	save.clear();

	return;
}

void prim(int start)
{
	sum = 0;
	int check = 0;
	int tweight,tnum,v1,v2;
	memset(visit,0,sizeof(visit));
	visit[start] = 1;

	save.reserve(vertex-1);

	while(1)
	{
		tweight = 9999999;
		tnum = 9999999;

		for(int i = 0;i < edge;i++)
		{
			if( visit[v[i].second.first] + visit[v[i].second.second] == 1)
			{
				if(v[i].first.first == tweight)
				{
					if(v[i].first.second < tnum)
					{
						tnum = v[i].first.second;
						v1 = v[i].second.first;
						v2 = v[i].second.second;
						break;
						//break; means
						//Sort weight of edge -> The fastest number of the same value
					}
				}
				else if(v[i].first.first < tweight)
				{
					tnum = v[i].first.second;
					tweight = v[i].first.first;
					v1 = v[i].second.first;
					v2 = v[i].second.second;
					break;
					//braek; means
					//Sort weight of edge -> The fastest number of the same value
				}
			}
		}

		sum += tweight;

		visit[v1] = visit[v2] = 1;

		save.push_back(tnum);

		check++;
	
		if(check == vertex - 1)
			break;
	}

	fout<<"Tree edges by Prim algorithm with starting vertex "<<start<<": "<<sum<<endl;
	for(int i = 0;i < save.size();i++)
		fout<<save[i]<<endl;

	save.clear();

	return;
}

int main()
{
	start_t = clock();

	finFunction();

	sortFunction();

	kruskal();

	prim(0);

	prim(vertex/2);

	prim(vertex-1);

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
