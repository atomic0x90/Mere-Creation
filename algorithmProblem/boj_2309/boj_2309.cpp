#include <iostream>
#include <algorithm>

using namespace std;

int arr[10];
int result[8];
int i,j;
int sum = 0;
int flag1 = 0;
int check1,check2;

int main()
{
	for(i = 0;i < 9;i++)
	{
		cin>>arr[i];
		sum += arr[i];
	}

	for(i = 0;i < 9;i++)
	{
		for(j = 0;j < 9;j++)
		{
			if(i == j) continue;

			if(sum - arr[i] - arr[j] == 100)
			{
				check1 = i;
				check2 = j;
				flag1++;

				break;
			}
		}

		if(flag1)
			break;
	}

	int tmp = 0;
	for(i = 0;i < 9;i++)
	{
		if(check1 != i && check2 != i)
		{
			result[tmp] = arr[i];
			tmp++;
		}
	}

	sort(result,result+7);

	for(i = 0;i < 7;i++)
		cout<<result[i]<<endl;

	return 0;
}
