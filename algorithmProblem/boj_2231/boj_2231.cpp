#include <iostream>

using namespace std;

int num;
int i;
int result = 0;

int main()
{
	cin>>num;

	for(i = 1;i < num;i++)
	{
		int tmp1 = 0,tmp2 = i;
		while(1)
		{
			if(tmp2 < 10)
			{
				tmp1 += tmp2;
				break;
			}
			tmp1 += tmp2 % 10;
			tmp2 /= 10;
		}

		if(tmp1 + i == num)
		{
			result = i;
			break;
		}
	}

	cout<<result<<endl;

	return 0;
}
