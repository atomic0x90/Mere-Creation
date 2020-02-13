#include <iostream>

#include <cstring>

using namespace std;

int main()
{
	int a,n = 0;
	int num[42];

	memset(num,0,sizeof(num));

	for(int i = 0;i < 10;i++)
	{
		cin>>a;

		num[a%42]++;
	}


	for(int i = 0;i < 42;i++)
	{
		if(num[i])
			n++;
	}

	cout<<n<<endl;

	return 0;
}
