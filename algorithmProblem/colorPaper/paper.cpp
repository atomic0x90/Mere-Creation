#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

int testCase;
int x[2000] = {0,},y[2000] = {0,},xx[2000] = {0,},yy[2000] = {0,};
int checkOL[2000] = {0,};
int tx[2000] = {0,},ty[2000] = {0,},txx[2000] = {0,},tyy[2000] = {0,};

int tmpx[2000] = {0,},tmpy[2000] = {0,},tmpxx[2000] = {0,},tmpyy[2000] = {0,};

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
					tmpy[tmpv] = tyy[k];
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
					tmpy[tmpv] = tmpyy[j];
					tmpv++;

					tmpInit(j);

					checkOL[i] = 1;
					cout<<"T";
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

		//merge??
		/*
		for(int j = 0;j < tmpv;j++)
		{
			if(tmpxx[j] - tmpx[j] > 0 && tmpyy[j] - tmpy[j] > 0)
			{
				for(int k = 0;k < ti;k++)
				{
					if(tx[k] == tmpx[j] && txx[k] == tmpxx[j] && tyy[k] == tmpy[j])
					{	//x ==, 위로 이어짐
						tyy[k] = tmpyy[j];
					}
					else if(tx[k] == tmpx[j] && txx[k] == tmpxx[j] && ty[k] == tmpyy[j])
					{	//x ==, 아래로 이어임
						ty[k] = tmpyy[j];
					}
					else
					{
						tx[ti] = tmpx[j];
						txx[ti] = tmpxx[j];
						ty[ti] = tmpy[j];
						tyy[ti] = tmpyy[j];
	
						ti++;
					}
				}
			}
		}*/

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
	if(checkOL[in] != 0)
	{
		for(int i = 1;i < ve;i++)
		{	//tmpv 범위 조심
			if(tmpx[i] == -1 && tmpxx[i] == -1 && tmpy[i] == -1 && tmpyy[i] == -1)
				checkOL[in] = 2;
			else
			{
				checkOL[in] = 1;
				break;
			}
		}
	}
	
	if(checkOL[in] == 2)
		return;

	for(int i = 0;i < ve;i++)
	{
//		cout<<"\t"<<tmpx[i]<<" "<<tmpy[i]<<" "<<tmpxx[i]<<" "<<tmpyy[i]<<endl;
		if(tmpxx[i] - tmpx[i] > 0 && tmpyy[i] - tmpy[i] > 0)
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

	if(checkOL[in] == 0)
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
	
		cout<<x[i]<<" "<<xx[i]<<" "<<y[i]<<" "<<yy[i]<<endl;

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
