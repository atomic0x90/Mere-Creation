#include <iostream>

#include <cstring>

using namespace std;

string st;
int testCase;
int R;

int main()
{
	cin>>testCase;

	while(testCase)
	{
		cin>>R>>st;

		for(int i = 0;i < st.length();i++)
		{
			for(int j = 0;j < R;j++)
				cout<<st[i];
		}

		cout<<endl;

		testCase--;
	}

	return 0;
}
