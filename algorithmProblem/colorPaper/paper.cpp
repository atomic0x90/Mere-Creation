#include <iostream>
#include <fstream>

using namespace std;

ifstream fin("paper.inp");
ofstream fout("paper.out");

int testCase;
int x[20000] = {0,},y[20000] = {0,},xx[20000] = {0,},yy[20000] = {0,};
int checkOL[2000] = {0,};

void finFunction();
void overlapCheck();
void foutFunction();
void merge(int,int);

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
		
		i++;
		tmp--;
	}

	return;
}

void overlapCheck()
{
	int tmp1,tmp2;
	tmp1 = tmp2 = testCase-1;

	for(int i = tmp1;i >= 0;i--)
	{
		for(int j = tmp2;j > i;j--)
		{
			cout<<"tmp2 "<<tmp2<<endl;
			if(x[j] <= x[i] && xx[j] >= xx[i] && y[j] <= y[i] && yy[j] >= yy[i])
			{	//전부 덮일 경우
				x[i] = x[j];
				xx[i] = xx[j];
				y[i] = y[j];
				yy[i] = yy[j];

				checkOL[i] = 2;
				break;
			}
			//튀어나옴
			else if(x[i] == x[j] && xx[i] == xx[j] && y[i] >= y[j] && y[i] <= yy[j] && yy[i] >= yy[j])
			{	//x좌표 같고 y좌표 겹치는 경우(위로)
				y[i] = y[j];
				yy[j] = yy[i];

				checkOL[i] = 1;
			}
			else if(x[i] == x[j] && xx[i] == xx[j] && yy[i] >= y[j] && yy[i] <= yy[j] && y[i] <= y[j])
			{	//x좌표 같고 y좌표 겹치는 경우(아래로)
				yy[i] = yy[j];
				y[j] = y[i];

				checkOL[i] = 1;
			}
			else if(y[i] == y[j] && yy[i] == yy[j] && x[i] <= x[j] && xx[i] >= x[j] && xx[i] <= xx[j])
			{	//y좌표 같고 x좌표 겹치는 경우(왼쪽으로)
				x[j] = x[i];
				xx[i] = xx[j];

				checkOL[i] = 1;
			}
			else if(y[i] == y[j] && yy[i] == yy[j] && xx[i] >= xx[j] && x[i] >= x[j] && x[i] <= xx[j])
			{	//y좌표 같고 x좌표 겹치는 경우(오른쪽으로)
				x[i] = x[j];
				xx[j]=  xx[i];

				checkOL[i] = 1;
			}
			//모서리 겹치는 경우
			else if(x[i] <= x[j] && xx[i] >= x[j] && xx[i] <= xx[j] && yy[i] >= yy[j] && y[i] <= yy[j] && y[i] >= y[j])
			{	//left top
				tmp2++;
				x[tmp2] = x[i];
				xx[tmp2] = xx[j];
				y[tmp2] = y[i];
				yy[tmp2] = yy[j];

				tmp2++;
				x[tmp2] = x[j];
				xx[tmp2] = xx[i];
				y[tmp2] = y[j];
				yy[tmp2] = yy[i];

				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j] && yy[i] >= yy[j] && y[i] <= yy[j] && y[i] >= y[j])
			{	//right top
				tmp2++;
				x[tmp2] = x[j];
				xx[tmp2] = xx[i];
				y[tmp2] = y[i];
				yy[tmp2] = yy[j];

				tmp2++;
				x[tmp2] = x[i];
				xx[tmp2] = xx[j];
				y[tmp2] = y[j];
				yy[tmp2] = yy[i];

				checkOL[i] = 1;
			}
			else if(x[i] <= x[j] && xx[i] >= x[j] && xx[i] <= xx[j] && y[i] <= y[j] && yy[i] >= y[j] && yy[i] <= yy[j])
			{	//left bottom
				tmp2++;
				x[tmp2] = x[i];
				xx[tmp2] = xx[j];
				y[tmp2] = y[j];
				yy[tmp2] = yy[i];

				tmp2++;
				x[tmp2] = x[j];
				xx[tmp2] = xx[i];
				y[tmp2] = y[i];
				yy[tmp2] = yy[j];
				
				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j] && y[i] <= y[j] && yy[i] >= y[j] && yy[i] <= yy[j])
			{	//right bottom
				tmp2++;
				x[tmp2] = x[j];
				xx[tmp2] = xx[i];
				y[tmp2] = y[j];
				yy[tmp2] = yy[i];

				tmp2++;
				x[tmp2] = x[i];
				xx[tmp2] = xx[j];
				y[tmp2] = y[i];
				yy[tmp2] = yy[j];

				checkOL[i] = 1;
			}
			//i 종이가 더 작은 경우
			else if(y[i] >= y[j] && yy[i] <= yy[j] && x[i] < x[j] && xx[i] >= x[j] && xx[i] <= xx[j])
			{	//왼쪽으로 튀어나온 경우
				xx[i] = xx[j];

				checkOL[i] = 1;
			}
			else if(y[i] >= y[j] && yy[i] <= yy[j] && xx[i] > xx[j] && x[i] >= x[j] && x[i] <= xx[j])
			{	//오른쪽으로 튀어나온 경우
				x[i] = x[j];

				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && xx[i] <= xx[j] && yy[i] > yy[j] && y[i] >= y[j] && y[i] <= yy[j])
			{	//위로 튀어나온 경우
				y[i] = y[j];

				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && xx[i] <= xx[j] && y[i] < y[j] && yy[i] <= yy[j] && yy[i] >= y[j])
			{	//아래로 튀어나온 경우
				yy[i] = yy[j];

				checkOL[i] = 1;
			
			}
			//i 종이가 더 큰 경우
			else if(x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j] && y[i] <= y[j] && yy[i] >= yy[j])
			{	//i 종이 왼쪽에 튀어나온 경우
				xx[j] = xx[i];

				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j] && y[i] <= y[j] && yy[i] >= yy[j])
			{	//i 종이 오른쪽에 튀어나온 경우
				x[j] = x[i];

				checkOL[i] = 1;
			}
			else if(y[i] >= y[j] && y[i] <= yy[j] && yy[i] >= yy[j] && x[i] >= x[j] && xx[i] <= xx[j])
			{	//i 종이 아래쪽에 튀어나온 경우
				yy[j] = yy[i];

				checkOL[i] = 1;
			}
			else if(y[i] <= y[j] && yy[i] >= y[j] && yy[i] <= yy[j] && x[i] >= x[j] && xx[i] <= xx[j])
			{	//i 종이 위쪽에 튀어나온 경우
				y[j] = y[i];

				checkOL[i] = 1;
			}
			else if(y[i] >= y[j] && yy[i] <= yy[j] && x[i] <= x[j] && xx[i] >= xx[j])
			{	//가로로 통과한 경우
				checkOL[i] = 1;
			}
			else if(x[i] >= x[j] && xx[i] <= xx[j] && y[i] <= y[j] && yy[i] >= yy[j])
			{	//세로로 통과한 경우
				checkOL[i] = 1;
			}
		}
		//merge(i,tmp2);
	}

	return;
}

void merge(int s,int l)
{
	for(int i = s;i <= l;i++)
	{
		for(int j = i;j <= l;j++)
		{
			if(x[i] == x[j] && xx[i] == xx[j] && y[i] <= y[j] && yy[i] >= y[j] && yy[i] <= yy[j])
			{	//x좌표 같고 아래로
				y[j] = y[i];
				yy[i] = yy[j];
			}
			else if(x[i] == x[j] && xx[i] == xx[j] && y[i] >= y[j] && y[i] <= yy[j] && yy[i] >= yy[j])
			{	//x좌표 같고 위로
				y[i] = y[j];
				yy[j] = yy[i];
			}
			else if(y[i] == y[j] && yy[i] == yy[j] && x[i] <= x[j] && xx[i] >= x[j] && xx[i] <= xx[j])
			{	//y좌표 같고 왼쪽으로
				x[j] = x[i];
				xx[i] = xx[j];
			}
			else if(y[i] == y[j] && yy[i] == yy[j] && x[i] >= x[j] && x[i] <= xx[j] && xx[i] >= xx[j])
			{	//y좌표 같고 오른쪽으로
				x[i] = x[j];
				xx[j] = xx[i];
			}
		}
	}
}

void foutFunction()
{
	int t0,t1,t2;
	t0 = t1 = t2 = 0;
	for(int i = 0;i<testCase;i++)
	{
		if(checkOL[i] == 2)
			t2++;
		else if(checkOL[i] == 1)
			t1++;
		else
			t0++;
	}
	cout<<t2<<" "<<t1<<" "<<t0<<endl;

	return;
}

int main()
{
	finFunction();
	overlapCheck();
	cout<<"testCase "<<testCase<<endl;
	for(int i = 0;i<testCase;i++)
	{
		cout<<x[i]<<" "<<y[i]<<" "<<xx[i]<<" "<<yy[i]<<" "<<checkOL[i]<<endl;
	}
	foutFunction();

	fin.close();
	fout.close();
	return 0;
}
