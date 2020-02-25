#include <iostream>

#include <cstring>

using namespace std;

int testCase;
int result = 0;
string st;

int main()
{
	cin>>testCase;

	cin>>st;

	for(int i = 0;i < testCase;i++)
		result += st[i] - '0';

	cout<<result<<endl;

	return 0;
}
