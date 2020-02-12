#include <iostream>

using namespace std;

int main()
{
	int a,result = 0;

	cin>>a;

	for(int i = 1;i <= a;i++)
		result += i;

	cout<<result<<endl;

	return 0;
}
