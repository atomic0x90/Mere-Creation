#include <iostream>

using namespace std;

int testCase;
int i = 0;
int arr[100001];

long long result = 0;
long long MAX[100001];

int main()
{
	cin>>testCase;

	for(i = 0;i < testCase;i++)
		cin>>arr[i];

	MAX[0] = arr[0];
	result = arr[0];

	for(i = 1;i < testCase;i++)
	{
		if(MAX[i-1] + arr[i] > arr[i])
			MAX[i] = MAX[i-1] + arr[i];
		else
			MAX[i] = arr[i];
	}
	for(i = 0;i < testCase;i++)
	{
		if(result < MAX[i])
			result = MAX[i];
	}
	cout<<result<<endl;

	return 0;
}
