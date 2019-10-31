#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

int testCase;
int x[2000] = {0,},y[2000] = {0,},xx[2000] = {0,},yy[2000] = {0,};
int checkOL[2000] = {0,};
int tx[2000] = {0,},ty[2000] = {0,},txx[2000] = {0,},tyy[2000] = {0,};

int tmpx[40000] = {0,},tmpy[40000] = {0,},tmpxx[40000] = {0,},tmpyy[40000] = {0,};

int checkin[40000] = {0,};

int ti = 0;

void finFunction();
void overlapCheck();
void merge(int,int);
void foutFunction();
void tmpInit(int);

void tmpInit(int i)
{
	tmpx[i] = -1;
	tmpxx[i] = -1;
	tmpy[i] = -1;
	tmpyy[i] = -1;

	return;
}

void overlapCheck()
{
	int tmp = testCase-1;
	
	for(int i = tmp;i >= 0;i--)
	{	//전체
		int tmpv = 1;
		tmpx[0] = x[i],tmpy[0] = y[i],tmpxx[0] = xx[i],tmpyy[0] = yy[i];
		
		cout<<x[i]<<" "<<y[i]<<" "<<xx[i]<<" "<<yy[i]<<" "<<tmpv<<" "<<ti<<endl;
		
		for(int j = 0;j<40000;j++)
			checkin[j] = 0;

		for(int j = 0;j < tmpv;j++)
		{	//나눠졌을 경우
			for(int k = 0;k < ti;k++)
			{	//tx 검사
				//o
				if(tmpx[j] >= tx[k] && tmpxx[j]<= txx[k] && tmpy[j] >= ty[k] && tmpyy[j] <= tyy[k])
				{	//전부 덮일경우
					tmpInit(j);

					checkOL[i] = 2;
					cout<<"A";

					checkin[j] = 2;
					break;	//Break mean's 'tmpInit(j)'
				}
				//o
				else if(tmpx[j] == tx[k] && tmpxx[j] == txx[k] && tmpy[j] >= ty[k] && tmpy[j] < tyy[k] && tmpyy[j] > tyy[k])
				{	//x ==, y위로겹
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					
					tmpInit(j);

					checkOL[i] = 1;
					tmpv++;
					cout<<"B";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] == tx[k] && tmpxx[j] == txx[k] && tmpyy[j] <= tyy[k] && tmpyy[j] > ty[k] && tmpy[j] < ty[k])
				{	//x ==, y아래로 겹
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];

					tmpInit(j);

					checkOL[i] = 1;
					tmpv++;
					cout<<"C";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpy[j] == ty[k] && tmpyy[j] == tyy[k] && tmpx[j] < tx[k] && tmpxx[j] <= txx[k] && tmpxx[j] > tx[k])
				{	//y ==, 왼쪽으로 겹
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tyy[k];

					tmpInit(j);

					checkOL[i] = 1;
					tmpv++;
					cout<<"D";
					
					checkin[j] = 1;
					break;
				}
				else if(tmpy[j] == ty[k] && tmpyy[j] == tyy[k] && tmpxx[j] > txx[k] && tmpx[j] >= tx[k] && tmpx[j] < txx[k])
				{	//y ==, 오른쪽으로 겹
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tyy[k];
					
					tmpInit(j);
					
					checkOL[i] = 1;
					tmpv++;
					cout<<"E";

					checkin[j] = 1;
					break;
				}
				//모서리
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > tx[k] && tmpxx[j] <= txx[k] && tmpy[j] >= ty[k] && tmpy[j] < tyy[k] && tmpyy[j] > tyy[k])
				{	//i 종이 기준 right bottom
					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"F";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > tx[k] && tmpxx[j] <= txx[k] && tmpy[j] < ty[k] && tmpyy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//i 종이 기준 right top
					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;
					
					tmpInit(j);

					checkOL[i] = 1;
					cout<<"G";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] >= tx[k] && tmpx[j] < txx[k] && tmpxx[j] > txx[k] && tmpy[j] >= ty[k] && tmpy[j] < tyy[k] && tmpyy[j] > tyy[k])
				{	//i 종이 기준 left bottom
					//아래 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"H";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] >= tx[k] && tmpx[j] < txx[k] && tmpxx[j] > txx[k] && tmpy[j] < ty[k] && tmpyy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//i 종이 기준 left top
					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					//위 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"I";

					checkin[j] = 1;
					break;
				}
				//i 종이가 위의 종이보다 작을 경우 (통과)
				
				//i 종이가 y가 짧을 경우
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > tx[k] && tmpxx[j] <= txx[k] && tmpy[j] >= ty[k] && tmpyy[j] <= tyy[k])
				{	//(1) 'ㅓ' 모양, i 종이가 '-'
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"J";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > txx[k] && tmpy[j] >= ty[k] && tmpyy[j] <= tyy[k])
				{	//(2) '+' 모양, i 종이가 '-'
					//왼쪽 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//오른쪽 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"K";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] >= tx[k] && tmpx[j] < txx[k] && tmpxx[j] > txx[k] && tmpy[j] >= ty[k] && tmpyy[j] <= tyy[k])
				{	//(3) 'ㅏ' 모양, i 종이가 '-'
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"L";

					checkin[j] = 1;
					break;
				}
				//i 종이가 x가 짧을 경우
				//o
				else if(tmpx[j] >= tx[k] && tmpxx[j] <= txx[k] && tmpy[j] >= ty[k] && tmpy[j] < tyy[k] && tmpyy[j] > tyy[k])
				{	//(1) 'ㅗ' 모양, i 종이가 'ㅣ'
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"M";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] >= tx[k] && tmpxx[j] <= txx[k] && tmpy[j] < ty[k] && tmpyy[j] > tyy[k])
				{	//(2) '+' 모양, i 종이가 'ㅣ'
					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"N";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] >= tx[k] && tmpxx[j] <= txx[k] && tmpy[j] < ty[k] && tmpyy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//(3) 'ㅜ' 모양, i 종이가 'ㅣ'
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);
					
					checkOL[i] = 1;
					cout<<"O";

					checkin[j] = 1;
					break;
				}
				//i 종이가 더 클 경우
				//사각형 9 등분 (x,y)
				/*
				else if(tmpx[j] >= tx[k] && tmpxx[j] > tx[k] && tmpxx[j] > txx[k] && tmpy[j] < ty[k] && tmpyy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//(1) (left,top)
					//오른쪽 나눔
					tmpx[tmpv] = tmpx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//왼쪽 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);
	
					checkOL[i] = 1;
					break;
				}*/
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > txx[k] && tmpy[j] < ty[k] && tmpyy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//(2) (middle,top)
					//왼쪽 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					//오른쪽 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"P";

					checkin[j] = 1;
					break;
				}
				/*
				else if(tmpx[j] < tx[k] && tmpxx[j] > tx[k] && tmpxx[j] <= txx[k] && tmpy[j] > ty[k] && tmpyy[j] <= tyy[k])
				{	//(3) (right,top)
					//왼쪽 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//오른쪽 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					break;
				}*/
				//o
				else if(tmpx[j] >= tx[k] && tmpx[j] < txx[k] && tmpxx[j] > txx[k] && tmpy[j] < ty[k] && tmpyy[j] > tyy[k])
				{	//(4) (left,middle)
					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 나눔
					tmpx[tmpv] =  txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"Q";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > txx[k] && tmpy[j] < ty[k] && tmpyy[j] > tyy[k])
				{	//(5) (middle,middle)
					//왼쪽 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 위 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 아래 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;
					
					//오른쪽 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"R";

					checkin[j] = 1;
					break;
				}
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > tx[k] && tmpxx[j] <= txx[k] && tmpy[j] < ty[k] && tmpyy[j] > tyy[k])
				{	//(6) (right,middle)
					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = ty[k];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = ty[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"S";

					checkin[j] = 1;
					break;
				}
				/*
				else if(tmpx[j] >= tx[k] && tmpxx[j] > txx[k] && tmpy[j] >= ty[k] && tmpyy[j] > tyy[k])
				{	//(7) (left,bottom)
					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//아래 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					break;
				}*/
				//o
				else if(tmpx[j] < tx[k] && tmpxx[j] > txx[k] && tmpy[j] >= ty[k] && tmpy[j] < tyy[k] && tmpyy[j] > tyy[k])
				{	//(8) (middle,bottom)
					//왼쪽 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//가운데 나눔
					tmpx[tmpv] = tx[k];
					tmpxx[tmpv] = txx[k];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//오른쪽 나눔
					tmpx[tmpv] = txx[k];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"T "<<j<<" "<<k<<" ";

					checkin[j] = 1;
					break;
				}
				/*
				else if(tmpx[j] < tx[k] && tmpxx[j] <= txx[k] && tmpy[j] >= ty[k] && tmpyy[j] > tyy[k])
				{	//(9) (right,bottom)
					//위 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tmpxx[j];
					tmpy[tmpv] = tyy[k];
					tmpyy[tmpv] = tmpyy[j];
					tmpv++;

					//아래 나눔
					tmpx[tmpv] = tmpx[j];
					tmpxx[tmpv] = tx[k];
					tmpy[tmpv] = tmpy[j];
					tmpyy[tmpv] = tyy[k];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					break;
				}*/
			}
		}
		cout<<"check "<<checkOL[i]<<" "<<tmpv<<" "<<ti<<endl<<endl;
		
		for(int l = 0;l<tmpv;l++)
		{
			cout<<"\t"<<tmpx[l]<<" "<<tmpxx[l]<<" "<<tmpy[l]<<" "<<tmpyy[l]<<endl;
		}

		if(ti == 0)
		{	//tx 처음 값
			tx[0] = tmpx[0];
			txx[0] = tmpxx[0];
			ty[0] = tmpy[0];
			tyy[0] = tmpyy[0];

			ti++;
		}
		else 
			merge(tmpv,i);
	
		cout<<checkOL[i]<<endl<<endl;
	}

	for(int i = 0;i < ti;i++)
	{
		cout<<tx[i]<<" "<<txx[i]<<" "<<ty[i]<<" "<<tyy[i]<<endl;
	}
}

void merge(int ve,int in)
{
	int check = 0;
	cout<<"ve in "<<ve<<" "<<in<<endl;
	
	int t1,t2,t3;
	t1 = t2 = t3 = 0;
	for(int i = 0;i < ve;i++)
	{
		if(checkin[i] == 0)
			t1++;
		else if(checkin[i] == 1)
			t2++;
		else
			t3++;
	}
	if(t1 == ve)
		checkOL[in] = 0;
	else if(t1 == 0)
		checkOL[in] = 2;
	else
		checkOL[in] = 1;
	
	
	if(checkOL[in] == 2)
		return;

	for(int i = 0;i < ve;i++)
	{
//		cout<<"\t"<<tmpx[i]<<" "<<tmpy[i]<<" "<<tmpxx[i]<<" "<<tmpyy[i]<<endl;
		if(tmpx[i] != -1 && tmpxx[i] != -1 && tmpy[i] != -1 && tmpyy[i] != -1)// && tmpxx[i] - tmpx[i] > 0 && tmpyy[i] - tmpy[i] > 0)
		{
			check = 0;
/*			for(int j = 0;j < ti;j++)
			{
				if(tx[j] >= tmpx[i] && txx[j] <= tmpxx[i] && ty[j] >= tmpy[i] && tyy[j] <= tmpyy[i])
				{	//전부 겹침
					tx[j] = tmpx[i];
					txx[j] = tmpxx[i];
					ty[j] = tmpy[i];
					tyy[j] = tmpyy[i];
					check++;
				}
				
				if(tx[j] == tmpx[i] && txx[j] == tmpxx[i])
				{	//x ==
					if(ty[j] == tmpyy[i])
						ty[j] = tmpy[i];
					else if(ty[j] > tmpy[i] && ty[j] < tmpyy[i])
						ty[j] = tmpy[i];

					if(tyy[j] == tmpy[i])
						tyy[j] = tmpyy[i];
					else if(tyy[j] > tmpy[i] && tyy[j] < tmpyy[i])
						tyy[j] = tmpyy[i];

					check++;
				}
				
				if(ty[j] == tmpy[i] && tyy[j] == tmpyy[i])
				{	//y ==
					if(tx[j] == tmpxx[i])
						tx[j] = tmpx[i];
					else if(tmpx[i] < tx[j] && tmpxx[i] > tx[j])
						tx[j] = tmpx[i];

					if(txx[j] == tmpx[i])
						txx[j] = tmpxx[i];
					else if(tmpxx[i] > txx[j] && tmpx[i] < txx[j])
						txx[j] = tmpxx[i];
					check++;
				}
			}*/
			if(check == 0)
			{
				tx[ti] = tmpx[i];
				txx[ti] = tmpxx[i];
				ty[ti] = tmpy[i];
				tyy[ti] = tmpyy[i];
				ti++;
			}
		}
	}

//	if(checkOL[in] == 0)
	{
		for(int i = 0;i<ti;i++)
			cout<<tx[i]<<" "<<ty[i]<<" "<<txx[i]<<" "<<tyy[i]<<endl;
	}


	return;
}

void finFunction()
{
	fin>>testCase;

	int t1,t2,t3,t4;
	int i = 0,tmp = testCase;

	while(tmp)
	{
		fin>>t1>>t2>>t3>>t4;

		x[i] = t1;
		y[i] = t2;
		xx[i] = t1 + t3;
		yy[i] = t2 + t4;
	
		cout<<x[i]<<" "<<y[i]<<" "<<xx[i]<<" "<<yy[i]<<endl;

		i++;
		tmp--;
	}
	cout<<endl;

	return;
}

void foutFunction()
{
	int t0,t1,t2;
	t0 = t1 = t2 = 0;

	for(int i = 0;i < testCase;i++)
	{
		if(checkOL[i] == 0)
			t0++;
		else if(checkOL[i] == 1)
			t1++;
		else
			t2++;
	}
	cout<<t2<<" "<<t1<<" "<<t0<<endl;
	fout<<t2<<" "<<t1<<" "<<t0<<endl;
	return;
}

int main()
{
	finFunction();

	overlapCheck();

	foutFunction();
	return 0;
}
