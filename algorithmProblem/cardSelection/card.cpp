#include <iostream>
#include <fstream>

#include <time.h>

using namespace std;

ifstream fin("card.inp");
ofstream fout("card.out");

clock_t start_t;
double end_t;

int testCase;
int cardLength;
int cardLine[1001];

int tmpl[8];

int result;

int t2,t3,t4;
int tmp;

void finFunction();
void foutFunction();
void card();

void algo(int,int,int,int);

void foutFunction()
{
	for(int i = 1;i <= cardLength;i++)
		cout<<cardLine[i]<<" ";

	cout<<endl;
	cout<<result<<endl;

	fout<<result<<endl;
	return;
}

void finFunction()
{
	fin>>cardLength;

	for(int i = 1;i <= cardLength;i++)
		fin>>cardLine[i];

	return;
}

void algo(int len,int now,int t,int gap)	//gap 1 : x x o x o, gap 2 : x o x x o, o x x x o
{
	if(len < 1)
		return;
//	cout<<"len "<<len<<" now "<<now<<" t "<<t<<" gap "<<gap<<"\t\t";
//	cout<<cardLine[len+now-8]+tmp<<" "<<tmp<<" "<<cardLine[len+now-8]<<endl;
	//'now' init data : 8
	//
/*	
	if(t == 2)
	{
		if(tmp > t2)
			t2 = tmp;
	}
	else if(t == 3)
	{
		if(tmp > t3)
			t3 = tmp;
	}
	else if(t == 4)
	{
		if(tmp > t4)
			t4 = tmp;
	}
*/
	if(len <= 8)
	{
		cout<<"len "<<len<<" now "<<now<<" t "<<t<<" gap "<<gap<<"\t\t";
       		cout<<cardLine[now]+tmp<<" "<<tmp<<" "<<cardLine[now]<<endl;

		if(t == 2 && tmp != 0)
        	{
              		if(tmp > t2)
                	        t2 = tmp;
        	}
        	else if(t == 3 && tmp != 0)
        	{
                	if(tmp > t3)
        	                t3 = tmp;
        	}	
        	else if(t == 4 && tmp != 0)
        	{
               		if(tmp > t4)
               	        	t4 = tmp;
        	}
//		tmp += cardLine[now];
		if(gap == 1)
		{
			if(now > 3)
			{
				tmp += cardLine[now];
				algo(len,now-3,t,2);
				tmp -= cardLine[now];
			}
			
			if(now > 4)
			{
				tmp += cardLine[now];
				algo(len,now-4,t,2);
				tmp -= cardLine[now];
			}

			if(now <= 3)
			{
				tmp += cardLine[now];
				if(t == 2)
                                {
                                        if(tmp > t2)
                                                t2 = tmp;
                                }
                                else if(t == 3)
                                {
                                        if(tmp > t3)
                                                t3 = tmp;
                                }
                                else if(t == 4)
                                {
                                        if(tmp > t4)
                                                t4 = tmp;
                                }
				tmp -= cardLine[now];
			}
		}
		else if(gap == 2)
		{
			if(now > 2 && now != 3)
			{
				tmp += cardLine[now];
				algo(len,now-2,t,1);
				tmp -= cardLine[now];
			}

			if(now > 3)
			{
				tmp += cardLine[now];
				algo(len,now-3,t,2);
				tmp -= cardLine[now];
			}

			if(now > 4)
			{
				tmp += cardLine[now];
				algo(len,now-4,t,2);
				tmp -= cardLine[now];
			}

			if(now <= 3)
			{
				tmp += cardLine[now];
				if(t == 2)
				{
					if(tmp > t2)
						t2 = tmp;
				}
				else if(t == 3)
				{
					if(tmp > t3)
						t3 = tmp;
				}
				else if(t == 4)
				{
					if(tmp > t4)
						t4 = tmp;
				}

				tmp -= cardLine[now];
			}
		}
	}
	else
	{
		if(t == 2)
                {
                        if(tmp > t2 && tmp != 0)
                                t2 = tmp;
                }
                else if(t == 3 && tmp != 0)
                {
                        if(tmp > t3)
                                t3 = tmp;
                }
                else if(t == 4 && tmp != 0)
                {
                        if(tmp > t4)
                                t4 = tmp;
                }
		cout<<"len "<<len<<" now "<<now<<" t "<<t<<" gap "<<gap<<"\t\t";
        cout<<cardLine[len+now-8]+tmp<<" "<<tmp<<" "<<cardLine[len+now-8]<<endl;
//		tmp += cardLine[len+now-8];
		if(gap == 1)
		{
			if(now > 3)
			{
				tmp += cardLine[len+now-8];
				algo(len,now-3,t,2);
				tmp -= cardLine[len+now-8];
			}
			
			if(now > 4)
			{
				tmp += cardLine[len+now-8];
				algo(len,now-4,t,2);
				tmp -= cardLine[len+now-8];
			}

			if(now <= 3)
			{
				tmp += cardLine[len+now-8];
				if(t == 2)
				{
					if(tmp > t2)
						t2 = tmp;
				}
				else if(t == 3)
				{
					if(tmp > t3)
						t3 = tmp;
				}
				else if(t == 4)
				{
					if(tmp > t4)
						t4 = tmp;
				}
				tmp -= cardLine[len+now-8];
			}
		}
		else if(gap == 2)
		{
			if(now > 2)
			{
				tmp += cardLine[len+now-8];
				algo(len,now-2,t,1);
				tmp -= cardLine[len+now-8];
			}
			
			if(now > 3)
			{
				tmp += cardLine[len+now-8];
				algo(len,now-3,t,2);
				tmp -= cardLine[len+now-8];
			}
			
			if(now > 4)
			{
				tmp += cardLine[len+now-8];
				algo(len,now-4,t,2);
				tmp -= cardLine[len+now-8];
			}

			if(now <= 2)
			{
				tmp += cardLine[len+now-8];
				if(t == 2)
				{
					if(tmp > t2)
						t2 = tmp;
				}
				else if(t == 3)
				{
					if(tmp > t3)
						t3 = tmp;
				}
				else if(t == 4)
				{
					if(tmp > t4)
						t4 = tmp;
				}
				tmp -= cardLine[len+now-8];
			}
		}
	}

	return;
}

void card()
{
	int checkl = 2;

	result += cardLine[cardLength];

	for(int i = cardLength;i > 3;)
	{
		t2 = t3 = t4 = -10000;

		if(checkl == 2)
		{
			tmp = 0;
			if(i-2 > 8)
			{
//				if(i != cardLength)
//					algo(i-2,8,2,2);
//				else
					algo(i-2,8,2,1);
			}
			else
				algo(i-2,i-2,2,1);
		}


		cout<<endl;

		tmp = 0;
		if(i-3 > 8)
			algo(i-3,8,3,2);
		else
			algo(i-3,i-3,3,2);


		cout<<endl;


		tmp = 0;
		if(i-4 > 8)
			algo(i-4,8,4,2);
		else
			algo(i-4,i-4,4,2);


		cout<<endl;


		cout<<"t2 t3 t4 "<<t2<<" "<<t3<<" "<<t4<<endl;

		if(t2 > t3 && t2 > t4)
		{
			cout<<"T2 "<<cardLine[i-2]<<endl;
			checkl = 1;
			result += cardLine[i-2];

			i -= 2;
		}
		else if(t3 > t2 && t3 > t4)
		{
			cout<<"T3 "<<cardLine[i-3]<<endl;
			checkl = 2;
			result += cardLine[i-3];

			i -= 3;
		}
		else if(t4 > t2 && t4 > t3)
		{
			cout<<"T4 "<<cardLine[i-4]<<endl;
			checkl = 2;
			result += cardLine[i-4];

			i -= 4;
		}
		cout<<"checkl "<<checkl<<endl<<endl;
//		break;
	}
	return;
}

int main()
{
	fin>>testCase;

	while(testCase)
	{
		result = 0;
		finFunction();

		card();

		foutFunction();

		testCase--;
	}

	fin.close();
	fout.close();

	return 0;
}
