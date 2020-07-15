#include <iostream>
#include <fstream>

#include <queue>

#include <cstring>

#include <vector>
using namespace std;

int prc;
int rNum;

int systemR[51] = {0,};
int MAX[51][51] = {0,};
int ALLOCATION[51][51] = {0,};

int NEED[51][51] = {0,};

int now[51] = {0,};
int AVAILABLE[51] = {0,};

int nextP;
int nextR[51] = {0,};

int checkSAFE[51][51] = {0,};

string order;

queue <int> q;
queue <int> tq;

vector < vector <int> > v;

int checkV = 0;

ifstream fin("banker.inp");
ofstream fout("banker.out");

void finFunction()
{
	fin>>prc>>rNum;

	for(int i = 0;i < rNum;i++)
		fin>>systemR[i];

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			fin>>MAX[i][j];
	}

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			fin>>ALLOCATION[i][j];
	}

	return;
}

void orderFin()
{
	fin>>nextP;
	for(int i = 0;i < rNum;i++)
		fin>>nextR[i];

	return;
}

void availableAlgo()
{
	for(int i = 0;i < rNum;i++)
	{
		now[i] = 0;
		AVAILABLE[i] = 0;
	}
	for(int i = 0;i < rNum;i++)
	{
		for(int j = 0;j < prc;j++)
		{
			AVAILABLE[i] += ALLOCATION[j][i];
		}
		now[i] = AVAILABLE[i];
	}

	for(int i = 0;i < rNum;i++)
		AVAILABLE[i] = systemR[i] - AVAILABLE[i];

	return;
}

void needAlgo()
{
	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
			NEED[i][j] = MAX[i][j] - ALLOCATION[i][j];
	}

	return;
}

void checkRequest()
{
	int tmp1 = 0;
	int tmp2 = 0;
	int tmp3 = 0;

	for(int i = 0;i < rNum;i++)
	{
		if(nextR[i] > AVAILABLE[i])	//다음 요청이 현재 사용 가능한 범위를 벗어난 경우
		{
			tmp1++;
			break;
		}
	}


	for(int i = 0;i < rNum;i++)
	{
		if(NEED[nextP][i] < nextR[i])
		{
			tmp2++;
			break;
		}
	}

	for(int i = 0;i < prc;i++)
	{
		for(int j = 0;j < rNum;j++)
		{
			if(i == nextP)
				checkSAFE[i][j] = NEED[i][j] - nextR[j];
			else
				checkSAFE[i][j] = NEED[i][j];
		}
	}
	int tmpAV[51] = {0,};
	for(int i = 0;i < rNum;i++)
		tmpAV[i] = AVAILABLE[i] - nextR[i];
	
	int t1 = 0;
	int t2 = 0;
	for(int i = 0;i < prc;i++)
	{
		t1 = 0;
		for(int j = 0;j < rNum;j++)
		{
			if(checkSAFE[i][j] > tmpAV[j])
			{
				t1++;
				break;
			}
		}
		if(t1 != 0)
			t2++;
	}

	if(t2 == prc)
		tmp3++;


	if(tmp1 == 0 && tmp2 == 0 && tmp3 == 0)	//현재 사용 가능
	{
		for(int i = 0;i < rNum;i++)
			ALLOCATION[nextP][i] += nextR[i];
	}
	else	//현재 사용 불가 -> 큐에 넣고 대기
	{
		q.push(checkV);


		v[checkV].reserve(rNum + 1);

		for(int i = 0;i < rNum;i++)
			v[checkV][i] = nextR[i];

		v[checkV][rNum] = nextP;

		checkV++;
	}

	return;
}

void checkRelease()
{
//	cout<<"IN CHECK RELEASE"<<endl;
	for(int i = 0;i < rNum;i++)
	{
		ALLOCATION[nextP][i] -= nextR[i];
		NEED[nextP][i] += nextR[i];
	}

	availableAlgo();
/*

	cout<<"ALLOCATION"<<endl;
                for(int i = 0;i < prc;i++)
                {
                        for(int j = 0;j < rNum;j++)
                        {
                                cout<<ALLOCATION[i][j]<<" ";
                        }
                        cout<<endl;
                }
                cout<<endl;

                cout<<"NEED"<<endl;
                for(int i = 0;i < prc;i++)
                {
                        for(int j = 0;j < rNum;j++)
                                cout<<NEED[i][j]<<" ";
                        cout<<endl;
                }
                cout<<endl;

                cout<<"AV"<<endl;
                for(int i = 0;i < rNum;i++)
                        cout<<AVAILABLE[i]<<" ";
                cout<<endl;
*/

	while(1)
	{
		if(!q.empty())	//대기중인 prc가 있는 경우
		{
			int tmpF = q.front();
			int tmpCheck = 0;
/*
			cout<<"QUEUE "<<"tmpF "<<tmpF<<endl;
			for(int i = 0;i < rNum;i++)
				cout<<v[tmpF][i]<<" ";
			cout<<" 진짜 "<<v[tmpF][rNum]<<" "<<tmpF<<endl;

			cout<<"v "<<endl;
			for(int i = 0;i < rNum;i++)
				cout<<v[tmpF][i]<<" ";
			cout<<endl;
*/			for(int i = 0;i < rNum;i++)
			{
				if(v[tmpF][i] > AVAILABLE[i])
				{
					tmpCheck++;
					break;
				}
			}
			//
			//
			int tmpAV[51] = {0,};
			for(int i = 0;i < rNum;i++)
			{
				tmpAV[i] = AVAILABLE[i] - v[tmpF][i];
				if(AVAILABLE[i] - v[tmpF][i] >= 0)
				{}//	tmpAV[i] = AVAILABLE[i] - v[tmpF][i];
				else
				{
					tmpCheck++;
				}
			}
			for(int i = 0;i < prc;i++)
        		{
                		for(int j = 0;j < rNum;j++)
                		{
                                		checkSAFE[i][j] = NEED[i][j];
               			}
        		}

			for(int i = 0;i < rNum;i++)
				checkSAFE[v[tmpF][rNum]][i] -= v[tmpF][i];
/*
			cout<<"tmpAV"<<endl;
			for(int i = 0;i < rNum;i++)
				cout<<tmpAV[i]<<" ";
			cout<<endl<<"checkSAFE"<<endl;
			for(int i = 0;i < prc;i++)
			{
				for(int j = 0;j < rNum;j++)
					cout<<checkSAFE[i][j]<<" ";
				cout<<endl;
			}
*/
			int t1 = 0;
        		int t2 = 0;
        		for(int i = 0;i < prc;i++)
        		{
                		t1 = 0;
               			for(int j = 0;j < rNum;j++)
                		{
                        		if(checkSAFE[i][j] > tmpAV[j])
                        		{
                                		t1++;
                                		break;
                        		}
                		}
                		if(t1 != 0)
                        		t2++;
        		}

			if(t2 == prc)
				tmpCheck++;

//			cout<<" T2 : "<<t2<<" 000000000000000000000000 "<<tmpCheck<<endl;
			////

			if(tmpCheck == 0)	//사용 가능
			{
				for(int i = 0;i < rNum;i++)
				{
					ALLOCATION[v[tmpF][rNum]][i] += v[tmpF][i];
				}

				availableAlgo();
//				cout<<"OK"<<endl;
			}
			else
			{
//				cout<<"X"<<endl;
				tq.push(tmpF);
			//	break;
			}

			q.pop();
		}

		else
			break;
	}

	while(!tq.empty())
	{
		int tmp = tq.front();
		q.push(tmp);
		tq.pop();
	}


	return;
}

int main()
{
	finFunction();

	v.reserve(1000);

	while(1)
	{		
//		cout<<"---------------------------------------"<<endl;
		fin>>order;

		if(order == "quit")
			break;

		orderFin();
		needAlgo();
		availableAlgo();

		if(order == "request")
		{
			checkRequest();
		}
		else if(order == "release")
		{
			checkRelease();
		}


		availableAlgo();

		for(int i = 0;i < rNum;i++)
			fout<<AVAILABLE[i]<<" ";
		fout<<endl;
/*
		cout<<"ALLOCATION"<<endl;
		for(int i = 0;i < prc;i++)
		{
			for(int j = 0;j < rNum;j++)
			{
				cout<<ALLOCATION[i][j]<<" ";
			}
			cout<<endl;
		}	
		cout<<endl;

		cout<<"NEED"<<endl;
		for(int i = 0;i < prc;i++)
		{
			for(int j = 0;j < rNum;j++)
				cout<<NEED[i][j]<<" ";
			cout<<endl;
		}
		cout<<endl;

		cout<<"AV"<<endl;
		for(int i = 0;i < rNum;i++)
			cout<<AVAILABLE[i]<<" ";
		cout<<endl;

		cout<<"-----------------------------------------end"<<endl;
		*/
	}

	v.clear();
	fin.close();
	fout.close();

	return 0;
}
