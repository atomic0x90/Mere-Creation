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

typedef tuple <int,int,int> tu;	// weighted of edge, edge number, v

clock_t start_t;
double end_t;

vector < vector <tu> > v;

int visit[10001];

int vertex,edge;

void finFunction();
int prim();
int kruskal();
void init();
void sortFunction();

void init()
{
	memset(visit,0,sizeof(visit));

	return;
}


void sortFunction()
{
	for(int i = 0;i < vertex;i++)
	{
		sort(v[i].begin(),v[i].end());
	}

	for(int i = 0;i < vertex;i++)
        {
                cout<<v[i].size()<<endl;
                for(int j = 0;j < v[i].size();j++)
                {
                        cout<< get<0>(v[i][j])<<" "<< get<1>(v[i][j])<<" "<< get<2>(v[i][j])<<endl;
                }
        }

	return;
}

void finFunction()
{
	fin>>vertex>>edge;

	v.reserve(vertex);

	int t1,t2,t3;
	for(int i = 0;i < edge;i++)
	{
		fin>>t1>>t2>>t3;
		
		tu tmp = make_tuple(t3,i,t2);

		v[t1].push_back(tmp);

		tmp = make_tuple(t3,i,t1);

		v[t2].push_back(tmp);
	}

	for(int i = 0;i < vertex;i++)
	{
		cout<<v[i].size()<<endl;
		for(int j = 0;j < v[i].size();j++)
		{
			cout<< get<0>(v[i][j])<<" "<< get<1>(v[i][j])<<" "<< get<2>(v[i][j])<<endl;
		}
	}
	return;
}

int main()
{
	start_t = clock();

	init();

	finFunction();

	sortFunction();

	fin.close();
	fout.close();

	end_t = clock();
	cout<<(double)(end_t - start_t)/CLOCKS_PER_SEC<<endl;
	return 0;
}
