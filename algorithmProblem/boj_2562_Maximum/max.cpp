#include <iostream>

using namespace std;

int main()
{
	int a,max = 0,num;

	for(int i = 1;i < 10;i++)
	{
		cin>>a;

		if(a > max)
		{
			max = a;
			num = i;
		}
	}

	cout<<max<<endl<<num<<endl;

	return 0;
}
