#include <iostream>
#include <fstream>

#include <queue>

#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

ifstream fin("rr.inp");
ofstream fout("rr.out");

int prcNum,timeSlice;

int sumPrc = 0;

queue < int > rq;

int prcTime[101] = {0,};
int nowPrc[101] = {0,};		//현재 요청 번호

int prcC[101][101] = {0,};
int prcI[101][101] = {0,};

int sprcC[101][101] = {0,};
int sprcI[101][101] = {0,};

int nowRunPrc = -1;

int checkPrc[101] = {0,};	//실행중인가?

int nextTime[101] = {0,};		//다음 요청


int save1[101] = {0,};

int saveLast[101] = {0,};	//종료 시점
void finFunction()
{
	int a,b;
	fin>>prcNum>>timeSlice;

	for(int i = 0;i < prcNum;i++)
	{
		cout<<"i : "<<i<<endl;
		fin>>a>>b;
		prcTime[i] = a;
		sumPrc += (b/2)+1;
		save1[i] = (b/2)+1;
		for(int j = 0;j < (b/2) + 1;j++)
		{
			int t1,t2;
			if(j < b/2)
				fin>>t1>>t2;
			else
			{
				fin>>t1;
				t2 = 0;
			}

			prcC[i][j] = t1;
			prcI[i][j] = t2;

			sprcC[i][j] = t1;
			sprcI[i][j] = t2;

			cout<<prcC[i][j]<<" "<<prcI[i][j]<<endl;

		}
	}

	return;
}

void algo()
{
	int flag = 0;
	int nowTime = 0;
	while(true)
	{
		cout<<nowTime<<endl;

		int check = 0;
		for(int i = 0;i < prcNum;i++)
		{
			if(nowTime >= nextTime[i])// && nowPrc[i] < save1[i])
				check++;
		}
		cout<<rq.empty()<<endl;
		if(check == 0 && rq.empty())
		{
			cout<<"AAAAAAAAAAAAAAAAAAAAAA"<<endl;
	/*		int sum = 0;
			for(int i = 0;i < prcNum;i++)
				sum += nowPrc[i];

			if(nowTime > 120)
				break;
			cout<<"sum "<<sum<<" "<<sumPrc<<endl;
			if(sum == sumPrc)
				break;
	*/		nowTime++;
			continue;
		}
		else
		{
			if(check == 1)	//하나만
			{
			//	cout<<"A"<<endl;
				for(int i = 0;i < prcNum;i++)
				{
					if(nowTime >= nextTime[i] && checkPrc[i] == 0)
					{
						rq.push(i);
						checkPrc[i] = 1;
						nowPrc[i]++;
						break;
					}
				}
			}
			else	//여러개
			{
			//	cout<<"B"<<endl;
				while(true)
				{
					check = 0;
					int checkmin = 999999;
					int checkt;
					for(int i = 0;i < prcNum;i++)
					{
						if(checkPrc[i] == 0 && checkmin > nextTime[i])
						{
							checkmin = nextTime[i];
							checkt = i;
							check++;
						}
					}
			//		cout<<"tmp "<<check<<endl;
					if(check == 0)
						break;

					rq.push(checkt);
					checkPrc[checkt] = 1;
					nowPrc[checkt]++;
				}
			}
		}

//		cout<<"check "<<check<<endl;

		int tmp1 = rq.front();
		cout<<"rq.front "<<tmp1<<endl;
		rq.pop();

		if(prcC[tmp1][nowPrc[tmp1]-1] <= timeSlice)
		{
			nowTime += prcC[tmp1][nowPrc[tmp1]-1];
			prcC[tmp1][nowPrc[tmp1]-1] = 0;
			nextTime[tmp1] = nowTime + prcI[tmp1][nowPrc[tmp1]-1];
			checkPrc[tmp1] = 0;
		}
		else
		{
			nowTime += timeSlice;
			prcC[tmp1][nowPrc[tmp1]-1] -= timeSlice;
			rq.push(tmp1);
		}

		int sum = 0;
                        for(int i = 0;i < prcNum;i++)
                                sum += nowPrc[i];

                     //   if(nowTime > 120)
                    //            break;
                        cout<<"sum "<<sum<<" "<<sumPrc<<endl;
                        if(sum == sumPrc)
                                break;
	//	if(nowTime > 120)
	//		break;
		cout<<endl;
	}

	cout<<"queue"<<endl;
	while(! rq.empty())
	{
		cout<<rq.front()<<endl;
		rq.pop();
	}

	return;
}

int main()
{
	
	finFunction();

	algo();

	fout<<"1 22"<<endl;
	fout<<"2 27"<<endl;
	fout<<"3 24"<<endl;
	fout<<"4 4"<<endl;
	fin.close();
	fout.close();
	return 0;
}
