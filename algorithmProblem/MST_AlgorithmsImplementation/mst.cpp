#include <iostream>
#include <fstream>

#include <vector>
#include <tuple>
#include <algorithm>

#include <time.h>

#include <cstring>

using namespace std;

ifstream fin("mst.inp");
ofstream fout("mst.out");

typedef tuple <int,int,int,int> tu;	// weighted of edge, edge number, v1, v2

clock_t start_t;
double end_t;

vector < tu > v;

vector <int> save;

int visit[10001];

int vertex,edge;
int sum;

void finFunction();
int prim();
void kruskal();
void init();
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

	if(p1 < p2)
		visit[y] = p1;
	else
		visit[x] = p2;

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

void init()
{
	return;
}


void sortFunction()
{
	sort(v.begin(),v.end());

	cout<<"sort"<<endl;
	for(int i = 0;i < edge;i++)
        {
                cout<<get<0>(v[i])<<" "<<get<1>(v[i])<<" "<<get<2>(v[i])<<" "<<get<3>(v[i])<<endl;
        }

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

		tu tmp = make_tuple(t3,i,t1,t2);
		v.push_back(tmp);
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
		if( !checkParent( get<2>(v[i]) , get<3>(v[i]) ) )
		{
			sum += get<0>(v[i]);
			
			save.push_back(get<1>(v[i]));
			
			unionParent( get<2>(v[i]) , get<3>(v[i]) );
		}
	}

	fout<<"Tree edges by Kruskal algorithm: "<<sum<<endl;
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

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
