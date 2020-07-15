#include <iostream>
#include <fstream>

#include <cstring>	//memset
#include <queue>
#include <vector>

using namespace std;

ifstream fin("allocation.inp");
ofstream fout("allocation.out");

int nowTime = 0;
int prcNum;
int resultFF = -2;
int resultBF = -2;
int resultWF = -2;

int checkS[1000];
char checkM[1000];	//메모리
int checkPrc[1000];	//프로세스 사용
queue <int> q;
queue <int> tq;

vector < pair < pair<int,int>,pair<int,int> > > inp;	//요청 시간,실행 시간,크기,남은 시간

vector < pair < pair<int,int>,pair<int,int> > > FFS;
vector < pair < pair<int,int>,pair<int,int> > > bfs;
vector < pair < pair<int,int>,pair<int,int> > > wfs;

void finFunction();
void foutFunction();

void ffAlgo();
void bfAlgo();
void wfAlgo();

void Init();

int main()
{
	finFunction();

	Init();

	ffAlgo();

	Init();

	bfAlgo();

	Init();

	wfAlgo();

	foutFunction();
	
	inp.clear();
	FFS.clear();
	bfs.clear();
	wfs.clear();
	fin.close();
	fout.close();
	return 0;
}

void Init()
{
	nowTime = 0;
	memset(checkS,0,sizeof(checkS));
	memset(checkPrc,0,sizeof(checkPrc));
	memset(checkM,'t',sizeof(checkM));
	while(!q.empty())
		q.pop();
	while(!tq.empty())
		tq.pop();
	return;
}

void finFunction()
{
	fin>>prcNum;

	inp.reserve(prcNum);
	FFS.reserve(prcNum);
	bfs.reserve(prcNum);
	wfs.reserve(prcNum);
	
	for(int i = 0;i < prcNum;i++)
	{
		fin>>inp[i].first.first>>inp[i].first.second>>inp[i].second.first;
		inp[i].second.second = inp[i].first.second;// - inp[i].first.first;

		FFS[i].first.first = inp[i].first.first;
		FFS[i].first.second = inp[i].first.second;
		FFS[i].second.first = inp[i].second.first;
		FFS[i].second.second = inp[i].second.second;

		bfs[i].first.first = inp[i].first.first;
		bfs[i].first.second = inp[i].first.second;
		bfs[i].second.first = inp[i].second.first;
		bfs[i].second.second = inp[i].second.second;

		wfs[i].first.first = inp[i].first.first;
		wfs[i].first.second = inp[i].first.second;
		wfs[i].second.first = inp[i].second.first;
		wfs[i].second.second = inp[i].second.second;
	}
	return;
}

void foutFunction()
{
	fout<<resultFF<<endl;
	fout<<resultBF<<endl;
	fout<<resultWF<<endl;

	return;
}
//checkPrc 0 -> 아직 요청 안옴, 1 -> 현재 실행중, 2 -> 대기, 3 -> 종료
void ffAlgo()
{
	while(checkPrc[prcNum-1] != 1)
	{
		int flag = 0;
		//현재 시간에 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && FFS[i].second.second == 0)	//남은 시간 0
			{
				checkPrc[i] = 3;
				memset(checkM+checkS[i],'t',sizeof(char)*FFS[i].second.first);
				//fill(checkM+checkS[i],checkM+checkS[i]+FFS[i].second.first,0);
				flag = 1;
			}
		}


		//대기 큐 확인
		//
		while(!q.empty())
		{
			if(flag == 0)break;

			int tNum = q.front();
			q.pop();
/*	
			for(int a = 0;a < prcNum;a++)
				cout<<checkS[a]<<" ";
			cout<<endl;

			cout<<FFS[tNum].first.first<<" "<<FFS[tNum].first.second<<" ";
			cout<<FFS[tNum].second.first<<" "<<checkS[tNum]<<endl;
*/			int t1 = 0,t2 = 0,t3 = 0,maxT = 0;	//t1크기,t2끝,t3시작,maxT최대
			for(int i = 0;i < 1000;i++)
			{
				if(checkM[i] == 't')
				{
					t3 = i;
					for(int j = i;j < 1000;j++)
					{
						if(checkM[j] == 't')
						{
				//			t1++;
							if(j == 999)
							{
								t2 = j;
								break;
							}
						}
						else
						{
							t2 = j;
							break;
						}
					}
					if(t2 == 999) t2 = 1000;
					t1 = t2 - t3;
					i = t2;
					if(t1 > maxT)
						maxT = t1;

					t1 = 0;
					if(FFS[tNum].second.first <= maxT)	//대기 요청 성공
					{
						checkS[tNum] = t3;
						memset(checkM+t3,'f',sizeof(char)*FFS[tNum].second.first);
						//fill(checkM+t3,checkM+t3+FFS[tNum].second.first,tNum+10000);
						checkPrc[tNum] = 1;
						break;
					}
				}
			}

			if(checkPrc[tNum] == 2)	//아직 대기 해야함
			{
				tq.push(tNum);
			}
		}

		while(!tq.empty())
		{
			int t1 = tq.front();
			tq.pop();
			q.push(t1);
		}


		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 0 && FFS[i].first.first == nowTime)
			{
				int t1 = 0,t2,maxT = 0,t3;
				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == 't')
					{
						t3 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 't')
							{
							//	t1++;
								if(k == 999)
								{
									t2 = k;
									break;
								}
							}
							else
							{
								t2 = k;
								break;
							}
						}
						if(t2 == 999)t2 = 1000;
						t1 = t2 - t3;
						j = t2;
						if(t1 > maxT)
							maxT = t1;
						t1 = 0;
						if(FFS[i].second.first <= maxT)	//찾은 장소가 요청보다 큰 경우
						{
							checkS[i] = t3;
							memset(checkM+t3,'f',sizeof(char)*FFS[i].second.first);
							//fill(checkM+t3,checkM+t3+FFS[i].second.first,i+10000);
							//메모리에 프로세스 번호보다 10000 많이 저장

							checkPrc[i] = 1;
							break;	
						}
					}
				}

				if(checkPrc[i] == 0)	//대기 해야함
				{
					q.push(i);
					checkPrc[i] = 2;
				}
			}
		}//새로운 요청

		nowTime++;
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1)
			{
				FFS[i].second.second--;
			}
		}
/*		for(int i = 0;i < prcNum;i++)
                        cout<<checkPrc[i]<<endl;
                cout<<endl;

		cout<<"end"<<endl<<endl;
*/	}

/*		for(int a = 0;a < prcNum;a++)
                                cout<<checkS[a]<<" ";
                        cout<<endl;
*/
	resultFF = checkS[prcNum-1];

	return;
}

void bfAlgo()
{
	while(checkPrc[prcNum-1] != 1)
	{
		int flag = 0;
		//현재 시간에 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && bfs[i].second.second == 0)
			{
				checkPrc[i] = 3;
				memset(checkM+checkS[i],'t',sizeof(char)*bfs[i].second.first);
				//fill(checkM+checkS[i],checkM+checkS[i]+bfs[i].second.first,0);
				flag = 1;
			}
		}

		//대기 큐 확인
		while(!q.empty())
		{
			if(flag == 0)break;
			int tNum = q.front();
			q.pop();

			int t1 = 0,t2 = 0,t3 = 0,min = 1001;
			int s1 = 0,s2 = 0,s3 = 0;

			for(int j = 0;j < 1000;j++)
			{
				if(checkM[j] == 't')
				{
					t1 = j;
					for(int k = j;k < 1000;k++)
					{
						if(checkM[k] == 't')
						{
						//	t3++;
							if(k == 999)
							{
								t2 = k;
								break;
							}
						}
						else
						{
							t2 = k;
							break;
						}
					}
					if(t2 == 999) t2 = 1000;
					t3 = t2 - t1;
					j = t2;

					if(min > t3 && t3 >= bfs[tNum].second.first)
					{
						s1 = t1;
						s2 = t2;
						s3 = t3;
						min = t3;
					}
					t3 = 0;
				}
			}

			if(min == 1001)	//대기 해야함
			{
				tq.push(tNum);
			}
			else
			{
				checkS[tNum] = s1;
				checkPrc[tNum] = 1;
				memset(checkM+s1,'f',sizeof(char)*bfs[tNum].second.first);
				//fill(checkM+s1,checkM+s1+bfs[tNum].second.first,tNum+10000);
			}

		}

		while(!tq.empty())
		{
			int tNum = tq.front();
			tq.pop();
			q.push(tNum);
		}
	
		
		//새로운 요청
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 0 && bfs[i].first.first == nowTime)
			{
				//시작,끝,크기
				int t1 = 0,t2 = 0,t3 = 0,min = 1001;
				int s1 = 0,s2 = 0,s3 = 0;

				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == 't')
					{
						t1 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 't')
							{
						//		t3++;
								if(k == 999)
								{
									t2 = 999;
									break;
								}
							}
							else
							{
								t2 = k;
								break;
							}
						}
						if(t2 == 999)t2 = 1000;
						t3 = t2 - t1;
						j = t2;

						if(min > t3 && t3 >= bfs[i].second.first)
						{//크기가 요청보다 크고 찾은것 보다 작을 때
							s1 = t1;
							s2 = t2;
							min = t3;
							s3 = t3;
						}
						t3 = 0;
					}
		//			t3 = 0;

				}
				
				if(min == 1001)	//대기 해야함
				{
					q.push(i);
					checkPrc[i] = 2;
				}
				else	//요청 성공
				{
					checkS[i] = s1;
					checkPrc[i] = 1;
					memset(checkM+s1,'f',sizeof(char)*bfs[i].second.first);
					//fill(checkM+s1,checkM+s1+bfs[i].second.first,i+10000);
				}
			}
		}

		//
		
		nowTime++;
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1)
			{
				bfs[i].second.second--;
			}
		}
	}

	resultBF = checkS[prcNum-1];
	
	return;
}

void wfAlgo()
{
	while(checkPrc[prcNum-1] != 1)
	{
		int flag = 0;
		//현재 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && wfs[i].second.second == 0)
			{
				checkPrc[i] = 3;
				memset(checkM+checkS[i],'t',sizeof(char)*wfs[i].second.first);
				//fill(checkM+checkS[i],checkM+checkS[i]+wfs[i].second.first,0);
				flag = 1;
			}
		}

		//대기 큐 확인
		while(!q.empty())
		{
			if(flag == 0)break;

			int tNum = q.front();
			q.pop();

			int t1 = 0,t2 = 0,t3 = 0,max = -1;
			int s1 = 0,s2 = 0,s3 = 0;

			for(int j = 0;j < 1000;j++)
			{
				if(checkM[j] == 't')
				{
					t1 = j;
					for(int k = j;k < 1000;k++)
					{
						if(checkM[k] == 't')
						{
						//	t3++;
							if(k == 999)
							{
								t2 = 999;
								break;
							}
						}
						else
						{
							t2 = k;
							break;
						}
					}
					if(t2 == 999) t2 = 1000;
					t3 = t2 - t1;
					j = t2;
					if(max < t3 && t3 >= wfs[tNum].second.first)
					{
						s1 = t1;
						s2 = t2;
						s3 = t3;
						max = t3;
					}
					t3 = 0;
				}
			}

			if(max == -1)
			{
				tq.push(tNum);
			}
			else
			{
				checkS[tNum] = s1;
				checkPrc[tNum] = 1;
				memset(checkM+s1,'f',sizeof(char)*wfs[tNum].second.first);
				//fill(checkM+s1,checkM+s1+wfs[tNum].second.first,tNum+10000);
			}
		}

		while(!tq.empty())
		{
			int tNum = tq.front();
			q.push(tNum);
			tq.pop();
		}


		//새로운 요청
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 0 && wfs[i].first.first == nowTime)
			{	//시작,끝,크기
				int t1 = 0,t2 = 0,t3 = 0,max = -1;
				int s1 = 0,s2 = 0,s3 = 0;
				
				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == 't')
					{
						t1 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 't')
							{
						//		t3++;
								if(k == 999)
								{
									t2 = 999;
									break;
								}
							}
							else
							{
								t2 = k;
								break;
							}
						}
						if(t2 == 999)t2 = 1000;
						t3 = t2 - t1;
						j = t2;
						if(max < t3 && t3 >= wfs[i].second.first)
						{
							s1 = t1;
							s2 = t2;
							s3 = t3;
							max = t3;
						}
						t3 = 0;
					}
				}

				if(max == -1)	//대기 해야함
				{
					checkPrc[i] = 2;
					q.push(i);
				}
				else	//요청 성공
				{
					checkS[i] = s1;
					checkPrc[i] = 1;
					memset(checkM+s1,'f',sizeof(char)*wfs[i].second.first);
					//fill(checkM+s1,checkM+s1+wfs[i].second.first,i+10000);
				}

			}
		}

		//
		nowTime++;
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1)
				wfs[i].second.second--;
		}
	}

	resultWF = checkS[prcNum-1];

	return;
}
