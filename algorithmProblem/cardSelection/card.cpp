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

int result;

void finFunction();
void foutFunction();
void card();

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


void card()
{
	int tmp = cardLength;

	int c4,c3,c2;	//Card order
	int t2,t3,t4;	//Card sum data

	int checkl = tmp;	//Check last card;

	int tmpj = 2;

	for(int i = cardLength;i > 0;)
	{
		t2 = t3 = t4 = -10000;

		c4 = i - 4;
		c3 = i - 3;
		c2 = i - 2;
		
		cout<<"i "<<i<<" "<<cardLine[i]<<" "<<endl;
/*		if(c4 > 3)
			cout<<cardLine[c4]<<" "<<cardLine[c3]<<" "<<cardLine[c2]<<endl;
		else if(c3 > 3)
			cout<<cardLine[c3]<<" "<<cardLine[c2]<<endl;
		else if(c2 > 3)
			cout<<cardLine[c2]<<endl;
*/
		if(i > 3)
		{
			result += cardLine[i];
		
			if(c4 <= 3 && c4 > 0)
				t4 = cardLine[c4];
			else if(c4 > 3)
			{
				for(int j = tmpj;j < 5;j++)
				{
					if(c4 - j <= 3 && c4 - j > 0)
					{
						if(cardLine[c4] + cardLine[c4-j] > t4)
							t4 = cardLine[c4] + cardLine[c4-j];
					}
					else if(c4 - j > 3)
					{
						int k;
						if(j == 2)
							k = 3;
						else
							k = 2;
	
						for(;k < 5;k++)
						{
							if(c4 - j - k <= 3 && c4 - j - k > 0)
                               	        		{
                               	        	        	if(cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k] > t4)
                               	                         		t4 = cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k];
                               	     	 		}
							else if(c4 - j - k > 3)
							{
								int l;
								if(k == 2)
									l = 3;
								else
									l = 2;
								
								for(;l < 5;l++)
								{
									if(c4 - j - k - l <= 3 && c4 - j - k - l > 0)
									{
										if(cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k] + cardLine[c4-j-k-l] > t4)
                                       	                    	  		   	t4 = cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k] + cardLine[c4-j-k-l];
									}
									else if(c4 - j - k - l > 3)
									{
										int o;
										if(l == 2)
											o = 3;
										else
											o = 2;

										for(;o < 5;o++)
										{
											if(c4 - j - k - l - o > 0)
											{
												if(cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k] + cardLine[c4-j-k-l] + cardLine[c4-j-k-l-o] > t4)
                                                                                        		t4 = cardLine[c4] + cardLine[c4-j] + cardLine[c4-j-k] + cardLine[c4-j-k-l] + cardLine[c4-j-k-l-o];
										
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if(c3 <= 3 && c3 > 0)
				t3 = cardLine[c3];
			else if(c3 > 3)
			{
				for(int j = tmpj;j < 5;j++)
                                {
                                        if(c3 - j <= 3 && c3 - j > 0)
                                        {
                                                if(cardLine[c3] + cardLine[c3-j] > t3)
                                                        t3 = cardLine[c3] + cardLine[c3-j];
                                        }
                                        else if(c3 - j > 3)
                                        {
                                                int k;
                                                if(j == 2)
                                                        k = 3;
                                                else
                                                        k = 2;

                                                for(;k < 5;k++)
                                                {
                                                        if(c3 - j - k <= 3 && c3 - j - k > 0)
                                                        {
                                                                if(cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k] > t3)
                                                                	t3 = cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k];
                                                        }
                                                        else if(c3 - j - k > 3)
                                                        {
                                                                int l;
                                                                if(k == 2)
                                                                        l = 3;
                                                                else
                                                                        l = 2;

                                                                for(;l < 5;l++)
                                                                {
									if(c3 - j - k - l <= 3 && c3 - j - k - l > 0)
                                                                        {
                                                                                if(cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k] + cardLine[c3-j-k-l] > t3)
                                                                                        t3 = cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k] + cardLine[c3-j-k-l];
                                                                        }
                                                                        else if(c3 - j - k - l > 3)
                                                                        {
                                                                                int o;
                                                                                if(l == 2)
                                                                                        o = 3;
                                                                                else
                                                                                        o = 2;

                                                                                for(;o < 5;o++)
                                                                                {
											if(c3 - j - k - l - o > 0)
											{
                                                                                       		if(cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k] + cardLine[c3-j-k-l] + cardLine[c3-j-k-l-o] > t3)
                                                                                       		        t3 = cardLine[c3] + cardLine[c3-j] + cardLine[c3-j-k] + cardLine[c3-j-k-l] + cardLine[c3-j-k-l-o];
                                                                                	}
										}
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
			}
			
			if(tmpj == 2)
			{
			if(c2 <= 3 && c2 > 0)
				t2 = cardLine[c2];
			else if(c2 > 3)
			{
				for(int j = 3;j < 5;j++)
                                {
                                        if(c2 - j <= 3 && c2 - j > 0)
                                        {
                                                if(cardLine[c2] + cardLine[c2-j] > t2)
						{
                                                        t2 = cardLine[c2] + cardLine[c2-j];
//						cout<<"t2 "<<t2<<"j "<<j<<endl;
						}
                                        }
                                        else if(c2 - j > 3)
                                        {
                                                int k = 2;

                                                for(;k < 5;k++)
                                                {
                                                        if(c2 - j - k <= 3 && c2 - j - k > 0)
                                                        {
                                                                if(cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k] > t2)
								{
									t2 = cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k];
//								cout<<"t2 "<<t2<<"j k "<<j<<" "<<k<<endl;
								}
                                                        }
                                                        else if(c2 - j - k > 3)
                                                        {
                                                                int l;
                                                                if(k == 2)
                                                                        l = 3;
                                                                else
                                                                        l = 2;

                                                                for(;l < 5;l++)
                                                                {
									if(c2 - j - k - l <= 3 && c2 - j - k - l > 0)
                                                                        {
                                                                                if(cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k] + cardLine[c2-j-k-l] > t2)
										{        
											t2 = cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k] + cardLine[c2-j-k-l];
  //                                                                      	cout<<"t2 "<<t2<<" j k l "<<j<<" "<<k<<" "<<l<<"\t"<<cardLine[c2]<<" "<<cardLine[c2-j]<<" "<<cardLine[c2-j-k]<<" "<<cardLine[c2-j-k-l]<<endl;
										}
									}
                                                                        else if(c2 - j - k - l > 3)
                                                                        {
                                                                                int o;
                                                                                if(l == 2)
                                                                                        o = 3;
                                                                                else
                                                                                        o = 2;

                                                                                for(;o < 5;o++)
                                                                                {
											if(c2 - j - k - l - o > 0)
											{
                                                                                       		if(cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k] + cardLine[c2-j-k-l] + cardLine[c2-j-k-l-o] > t2)
												{
													t2 = cardLine[c2] + cardLine[c2-j] + cardLine[c2-j-k] + cardLine[c2-j-k-l] + cardLine[c2-j-k-l-o];
    //                                                                            		cout<<"t2 "<<t2<<" j k l o"<<j<<" "<<k<<" "<<l<<" "<<o<<"\t"<<cardLine[c2]<<" "<<cardLine[c2-j]<<" "<<cardLine[c2-j-k]<<" "<<cardLine[c2-j-k-l]<<" "<<cardLine[c2-j-k-l-o]<<endl;
												}
											}
										}
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
			}
			}
		
			checkl = i;

			if(t4 > t3 && t4 > t2)	//t4
			{
				i = c4;
				tmpj = 2;
			}
			else if(t3 > t4 && t3 > t2)	//t3
			{
				i = c3;
				tmpj = 2;
			}
			else if(t2 > t4 && t2 > t3)	//t2
			{
				i = c2;
				tmpj = 3;
			}
		
			cout<<"t data "<<t4<<" "<<t3<<" "<<t2<<endl;
		}
		/*
		else if(i > 3)		//Middle card
		{}
		*/
		else if(i <= 3)		//First card
		{
			result += cardLine[i];
			break;
		}
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
