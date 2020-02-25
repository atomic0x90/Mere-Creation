#include <iostream>

#include <cstring>
using namespace std;

string st;
int check[27];

int main()
{
	memset(check,-1,sizeof(check));

	cin>>st;

	for(int i = 0;i < st.length();i++)
	{
		if(check[st[i]-97] == -1)
			check[st[i]-97] = i;
	}

	for(int i = 0;i < 26;i++)
		cout<<check[i]<<" ";

	return 0;
}
