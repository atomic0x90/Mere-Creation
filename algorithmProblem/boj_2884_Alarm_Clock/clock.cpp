#include <iostream>

using namespace std;

int main()
{
	int h,m;

	cin>>h>>m;

	if(m >= 45)
		cout<<h<<" "<<m-45<<endl;
	else
	{
		m = 60 + m - 45;
		h--;

		if(h < 0)
			h = 23;

		cout<<h<<" "<<m<<endl;
	}

	return 0;
}
