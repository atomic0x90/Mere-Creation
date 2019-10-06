#include <iostream>
#include <fstream>

using namespace std;

ifstream finput("bowling.inp");
ofstream foutput("bowling.out");

int score[10][3];
int testCase,tmp1,tmp2,tmp3,result,strikeCheck[10],spareCheck[10];

int main()
{

	finput >> testCase;


	while(testCase > 0)
	{
		result = 0;

		for(int i = 0; i < 10; i++)
		{
			if(i != 9)
			{
				finput >> tmp1;
				score[i][0] = tmp1;

				if(tmp1 != 10)
				{
					finput >> tmp2;
					score[i][1] = tmp2;
				}
				
				if(score[i][0] == 10 || score[i][0] + score[i][1] == 10)
				{
					strikeCheck[i]++;
					
					for(int j = i-1; j >= 0; j--)
					{
						if(strikeCheck[j] == 0)
							break;
						else
							strikeCheck[j]++;
					}
				}
			}
			else
			{
				finput >> tmp1 >> tmp2;
				score[i][0] = tmp1;
				score[i][1] = tmp2;

				if((tmp1 == 10 || (tmp1 + tmp2) % 10 == 0) && (tmp1+tmp2) != 0)
				{
					finput >> tmp3;
					score[i][2] = tmp3;
				}
			}
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(i != 9)
			{
				if( (score[i][0] + score[i][1]) != 10)
				{
					result += score[i][0] + score[i][1];
				}
				else if(strikeCheck[i] != 0)
				{
					if(score[i][0] == 10)	//strike
					{
						if(strikeCheck[i] >= 3)
						{
							if(score[i+1][1] == 0 && score[i+2][1] == 0)
								result += 30;
							else if(score[i+1][1] == 0 && score[i+2][1] != 0)
								result += 20 + score[i+2][0];
							else if(score[i+1][1] != 0)
								result += 20;
						}
						else if(strikeCheck[i] == 2)
						{
							if(score[i+1][1] == 0)
								result += 20 + score[i+2][0];
							else if(score[i+1][1] != 0)
								result += 20;
						}
						else
							result += 10 + score[i+1][0] + score[i+1][1];
					}
					else	//spare
					{
						result += 10 + score[i+1][0];
					}
				}
			}
			else
			{
				result += score[i][0] + score[i][1] + score[i][2];
			}

		}

		foutput<<result<<endl;

		for(int i = 0; i < 10; i++)	// array initial
			score[i][0] = score[i][1] = score[i][2] = strikeCheck[i] = spareCheck[i] = 0;
		
		testCase--;
	}



	finput.close();
	foutput.close();
	
	return 0;
}
