#include <iostream>
#include <fstream>

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

int checkM[1000];	//메모리
int checkPrc[1000];	//프로세스 사용
queue <int> q;
queue <int> tq;

vector < pair < pair<int,int>,pair<int,int> > > inp;	//요청 시간,실행 시간,크기,남은 시간

vector < pair < pair<int,int>,pair<int,int> > > ffs;
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
	ffs.clear();
	bfs.clear();
	wfs.clear();
	fin.close();
	fout.close();
	return 0;
}

void Init()
{
	nowTime = 0;
	for(int i = 0;i < prcNum;i++)
	{
		checkPrc[i] = 0;
	}
	for(int i = 0;i < 1000;i++)
		checkM[i] = 0;
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
	ffs.reserve(prcNum);
	bfs.reserve(prcNum);
	wfs.reserve(prcNum);
	
	for(int i = 0;i < prcNum;i++)
	{
		fin>>inp[i].first.first>>inp[i].first.second>>inp[i].second.first;
		inp[i].second.second = inp[i].first.second;// - inp[i].first.first;

		ffs[i].first.first = inp[i].first.first;
		ffs[i].first.second = inp[i].first.second;
		ffs[i].second.first = inp[i].second.first;
		ffs[i].second.second = inp[i].second.second;

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
/*
void fcout()
{
	cout<<"Q State : "<<q.empty()<<endl;
	queue <int> tq2;
	while(!q.empty())
	{
		int tmp = q.front();
		cout<<tmp<<" ";
		q.pop();
		tq2.push(tmp);
	}
	cout<<endl;

	while(!tq2.empty())
	{
		int tmp = tq2.front();
		q.push(tmp);
		tq2.pop();
	}

	return;
}
*/
//checkPrc 0 -> 아직 요청 안옴, 1 -> 현재 실행중, 2 -> 대기, 3 -> 종료
void ffAlgo()
{
	while(checkPrc[prcNum-1] != 1)
	{
//		cout<<"nowTime : "<<nowTime<<endl;
//		fcout();
//		cout<<"start"<<endl;

		//현재 시간에 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && ffs[i].second.second == 0)	//남은 시간 0
			{
				checkPrc[i] = 3;
				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == i+10000)
					{
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == i + 10000)
								checkM[k] = 0;
							else
								break;
						}
						break;
					}
				}
			
			}
		}


		//대기 큐 확인
		//
		while(!q.empty())
		{
			int tNum = q.front();
			q.pop();

			int t1 = 0,t2 = 0,t3 = 0,maxT = 0;	//t1크기,t2끝,t3시작,maxT최대
			for(int i = 0;i < 1000;i++)
			{
				if(checkM[i] == 0)
				{
					t3 = i;
					for(int j = i;j < 1000;j++)
					{
						if(checkM[j] == 0)
						{
							t1++;
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
					i = t2;
					if(t1 > maxT)
						maxT = t1;

					t1 = 0;
					if(ffs[tNum].second.first <= maxT)	//대기 요청 성공
					{
						for(int k = t3;k < t3+ffs[tNum].second.first;k++)
							checkM[k] = tNum + 10000;

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
			if(checkPrc[i] == 0 && ffs[i].first.first == nowTime)
			{
				int t1 = 0,t2,maxT = 0,t3;
				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == 0)
					{
						t3 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 0)
							{
								t1++;
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
						j = t2;
						if(t1 > maxT)
							maxT = t1;

						t1 = 0;
						if(ffs[i].second.first <= maxT)	//찾은 장소가 요청보다 큰 경우
						{
//							cout<<"A max "<<maxT<<" ffs ";
//							cout<<ffs[i].second.first<<endl;
							for(int k = t3;k < t3+ffs[i].second.first;k++)
								checkM[k] = i + 10000;	
							//메모리에 프로세스 번호보다 10000 많이 저장

							checkPrc[i] = 1;
							break;	
						}
					}
				}

				if(checkPrc[i] == 0)	//대기 해야함
				{
//					cout<<"B"<<endl;
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
				ffs[i].second.second--;
			}
		}
	}

	for(int i = 0;i < 1000;i++)
	{
		if(checkM[i] == prcNum-1 + 10000)
		{
			resultFF = i;
			break;
		}
	}

	return;
}

void bfAlgo()
{
//	cout<<endl<<"bfAlgo"<<endl;
	while(checkPrc[prcNum-1] != 1)
	{
//		cout<<"nowTime "<<nowTime<<endl;
//		fcout();
		//현재 시간에 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && bfs[i].second.second == 0)
			{
				checkPrc[i] = 3;

				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == i + 10000)
					{
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == i + 10000)
								checkM[k] = 0;
							else
								break;
						}
						break;	
					}
				}
			}
		}

		//대기 큐 확인
		while(!q.empty())
		{
			int tNum = q.front();
			q.pop();

			int t1 = 0,t2 = 0,t3 = 0,min = 1001;
			int s1 = 0,s2 = 0,s3 = 0;

			for(int j = 0;j < 1000;j++)
			{
				if(checkM[j] == 0)
				{
					t1 = j;
					for(int k = j;k < 1000;k++)
					{
						if(checkM[k] == 0)
						{
							t3++;
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
					j = t2;

					if(min > t3 && t3 >= bfs[tNum].second.first)
					{
						s1 = t1;
						s2 = t2;
						s3 = t3;
						min = t3;

						if(t3 == bfs[tNum].second.first)
							break;
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
				checkPrc[tNum] = 1;
				for(int i = s1;i < s1+bfs[tNum].second.first;i++)
				{
					checkM[i] = tNum + 10000;
				}
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
					if(checkM[j] == 0)
					{
						t1 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 0)
							{
								t3++;
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
						j = t2;

//						cout<<t1<<" "<<t2<<" "<<t3<<" "<<min<<endl;
						if(min > t3 && t3 >= bfs[i].second.first)
						{//크기가 요청보다 크고 찾은것 보다 작을 때
							s1 = t1;
							s2 = t2;
							min = t3;
							s3 = t3;

							if(t3 == bfs[i].second.first)
								break;
						}
					}
					t3 = 0;
				}
				
//				cout<<"min "<<min<<endl<<endl;
				if(min == 1001)	//대기 해야함
				{
					q.push(i);
					checkPrc[i] = 2;
				}
				else	//요청 성공
				{
//					cout<<"A i "<<i<<" bfs "<<bfs[i].second.first<<" s1 "<<s1<<endl;
					checkPrc[i] = 1;
					for(int j = s1;j < s1+bfs[i].second.first;j++)
						checkM[j] = i + 10000;
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

	for(int i = 0;i < 1000;i++)
	{
		if(checkM[i] == prcNum-1 + 10000)
		{
			resultBF = i;
			break;
		}
	}
	return;
}

void wfAlgo()
{
//	cout<<endl<<endl<<"-----------------------"<<endl<<"wfAlgo"<<endl;
	while(checkPrc[prcNum-1] != 1)
	{
//		if(nowTime > 50)
//			break;
//		cout<<nowTime<<endl;
//		fcout();
		//현재 종료
		for(int i = 0;i < prcNum;i++)
		{
			if(checkPrc[i] == 1 && wfs[i].second.second == 0)
			{
//				cout<<"종료 "<<i<<endl;
				checkPrc[i] = 3;
				for(int j = 0;j < 1000;j++)
				{
					if(checkM[j] == i + 10000)
					{
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == i + 10000)
								checkM[k] = 0;
							else
								break;
						}
						break;
					}
				}
			}
		}

		//대기 큐 확인
		while(!q.empty())
		{
			int tNum = q.front();
			q.pop();

			int t1 = 0,t2 = 0,t3 = 0,max = -1;
			int s1 = 0,s2 = 0,s3 = 0;

			for(int j = 0;j < 1000;j++)
			{
				if(checkM[j] == 0)
				{
					t1 = j;
					for(int k = j;k < 1000;k++)
					{
						if(checkM[k] == 0)
						{
							t3++;
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
//				cout<<"큐 다시 대기 "<<tNum<<endl;
				tq.push(tNum);
			}
			else
			{
//				cout<<"큐 요청 성공 "<<tNum<<" "<<t1<<" "<<t2<<" "<<t3<<" "<<max<<endl;
				checkPrc[tNum] = 1;
				for(int j = s1;j < s1+wfs[tNum].second.first;j++)
					checkM[j] = tNum + 10000;
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
					if(checkM[j] == 0)
					{
						t1 = j;
						for(int k = j;k < 1000;k++)
						{
							if(checkM[k] == 0)
							{
								t3++;
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
//					cout<<"대기"<<endl;
					checkPrc[i] = 2;
					q.push(i);
				}
				else	//요청 성공
				{
//					cout<<"성공 "<<s1<<" "<<s2<<" "<<s3<<" "<<max<<" "<<wfs[i].second.first<<endl;
					checkPrc[i] = 1;
					for(int j = s1;j < s1+wfs[i].second.first;j++)
						checkM[j] = i + 10000;
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

	for(int i = 0;i < 1000;i++)
	{
		if(checkM[i] == prcNum-1+10000)
		{
			resultWF = i;
			break;
		}
	}

	return;
}
