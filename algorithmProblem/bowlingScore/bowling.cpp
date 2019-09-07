#include <iostream>
#include <fstream>

using namespace std;

ifstream finput("bowling.inp");
ofstream foutput("bowling.out");

int score[10][3];
int testCase,tmp1,tmp2,tmp3,result,strikeCheck[10];

int main()
{

	finput >> testCase;

	cout<<testCase<<endl;

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

				if(( (tmp1+tmp2) % 10 == 0) && (tmp1+tmp2) != 0)
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
				else if(score[i][0] == 10)	//strike
				{
					if(strikeCheck[i] == 1)
						result += score[i][0] + score[i+1][1] + score[i+1][0];
					else if(strikeCheck[i] == 2)
						result += score[i][0] + score[i+1][0] + score[i+1][1];
					else if(strikeCheck[i] >= 3)
						result += 30;
				}
				else if(score[i][0] != 10 && score[i][0] + score[i][1] == 10)	//spare
				{
					result += score[i][0] + score[i][1] + score[i+1][0];
				}
			}
			else
			{
				result += score[i][0] + score[i][1] + score[i][2];
			}

			cout<<"result: "<<result<<endl;
		}
/*
		for(int i = 0; i < 10; i++)
		{
			cout<<score[i][0]<<" "<<score[i][1]<<" "<<score[i][2]<<endl;
		}*/

		for(int i = 0; i < 10; i++)
			cout<<strikeCheck[i]<<endl;

		cout<<endl<<result<<endl;

		for(int i = 0; i < 10; i++)	// array initial
			score[i][0] = score[i][1] = score[i][2] = strikeCheck[i] = 0;
		
		testCase--;
	}



	finput.close();
	foutput.close();
	
	return 0;
}
