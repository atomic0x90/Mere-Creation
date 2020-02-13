#include <iostream>

#include <cstring>

using namespace std;

int main()
{
	int testCase;

	cin>>testCase;

	getchar();

	char tmp[81];
	int score[81];

	while(testCase)
	{
		int result = 0;
		int check = 0;

		memset(tmp,' ',sizeof(tmp));
		memset(score,0,sizeof(score));

		cin.getline(tmp,81);

		if(tmp[0] == 'O')
			score[0]++;

		for(int i = 1;i < sizeof(tmp);i++)
		{
			if(tmp[i] == ' ')
			{
				check = i;
				break;
			}

			if(tmp[i] == 'O')
				score[i] = score[i-1] + 1;
		}

		for(int i = 0;i < check;i++)
			result += score[i];

		cout<<result<<endl;

		testCase--;
	}

	return 0;
}
