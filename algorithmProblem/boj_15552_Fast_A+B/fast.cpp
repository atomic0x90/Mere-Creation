#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
//	cout.tie(NULL);

	int testCase;
	int a,b;

	cin>>testCase;

	for(int i = 0;i < testCase;i++)
	{
		cin>>a>>b;
		cout<<a+b<<"\n";
	}

	return 0;
}
