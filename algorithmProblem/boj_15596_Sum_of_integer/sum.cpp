#include <iostream>

using namespace std;

int sn(int);

int save[10001];

int sn(int n)
{
	int result = n;

	if(n >= 10000)
	{
		result += n/10000;
		n %= 10000;
	}
	if(n >= 1000)
	{
		result += n/1000;
		n %= 1000;
	}
	if(n >= 100)
	{
		result += n/100;
		n %= 100;
	}
	if(n >= 10)
	{
		result += n/10;
		n %= 10;
	}

	result += n;

	return result;
}

int main()
{
	for(int i = 1;i < 10001;i++)
		save[sn(i)] = 1;

	for(int i = 1;i < 10001;i++)
	{
		if(!save[i])
			cout<<i<<endl;
	}

	return 0;
}
