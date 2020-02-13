#include <iostream>

using namespace std;

int main()
{
	int n,max = -10000000,min = 10000000;
	int a;
	cin>>n;

	while(n)
	{
		cin>>a;

		if(a < min)
			min = a;

		if(a > max)
			max = a;
	
		n--;
	}

	cout<<min<<" "<<max<<endl;

	return 0;
}
