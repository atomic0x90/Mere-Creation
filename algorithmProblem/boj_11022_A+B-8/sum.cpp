#include <iostream>

using namespace std;

int main()
{
	int testCase;
	int a,b;

	cin>>testCase;

	for(int i = 1;i <= testCase;i++)
	{
		cin>>a>>b;
		cout<<"Case #"<<i<<": "<<a<<" + "<<b<<" = "<<a+b<<"\n";
	}

	return 0;
}
