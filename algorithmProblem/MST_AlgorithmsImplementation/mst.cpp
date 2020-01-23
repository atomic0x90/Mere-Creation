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
//		visit[y] = p1;
	
		for(int i = 0;i < vertex;i++)
		{
			if(visit[i] == visit[y])
				visit[i] = p1;
		}

		visit[y] = p1;
	}
	else
	{
//		visit[x] = p2;
	
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
//	cout<<"sort"<<endl;
	/*
	for(int i = 0;i < edge;i++)
        {
                cout<<get<0>(v[i])<<" "<<get<1>(v[i])<<" "<<get<2>(v[i])<<" "<<get<3>(v[i])<<endl;
        }
	*/
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
	//	cout<<!checkParent( get<2>(v[i]) , get<3>(v[i]) )<<endl;
		if( !checkParent( get<2>(v[i]) , get<3>(v[i]) ) )
		{
			sum += get<0>(v[i]);
			
			save.push_back(get<1>(v[i]));
			
			unionParent( get<2>(v[i]) , get<3>(v[i]) );

	//		cout<<find(3)<<" "<<find(6)<<" asdf "<<get<2>(v[i])<<" "<<get<3>(v[i])<<endl;
	//		cout<<find(4)<<" "<<find(get<2>(v[i]))<<" "<<find(get<3>(v[i]))<<endl<<endl;
		}
	}

//	cout<<find(3)<<" "<<find(6)<<endl;//<<" asdf "<<get<2>(v[i])<<" "<<get<3>(v[i])<<endl;

//	cout<<save.size()<<" "<<sum<<endl;

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
			if( visit[ get<2>(v[i]) ] + visit[ get<3>(v[i]) ] == 1)
			{
				if( get<0>(v[i]) == tweight)
				{
					if( get<1>(v[i]) < tnum)
					{
						tnum = get<1>(v[i]);
						v1 = get<2>(v[i]);
						v2 = get<3>(v[i]);
					}
				}
				else if( get<0>(v[i]) < tweight)
				{
					tnum = get<1>(v[i]);
					tweight = get<0>(v[i]);
					v1 = get<2>(v[i]);
					v2 = get<3>(v[i]);
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
