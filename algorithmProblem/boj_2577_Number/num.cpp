#include <iostream>

#include <cstring>

using namespace std;

int main()
{
	int a,b,c;
	long long d;
	int num[10];

	memset(num,0,sizeof(num));

	cin>>a>>b>>c;

	d = a * b * c;

	while(d / 10 || d % 10)
	{
		num[d%10]++;

		d /= 10;
	}

	for(int i = 0;i < 10;i++)
		cout<<num[i]<<endl;

	return 0;
}
