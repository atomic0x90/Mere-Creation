#include <iostream>

using namespace std;

int main()
{
	int a,n = 0,t1,t2,tmp;

	cin>>a;

	tmp = a;

	while(1)
	{
		t2 = tmp % 10;
		t1 = tmp / 10;

		tmp = (t2 * 10) + (t1 + t2) % 10;

		n++;

		if(tmp == a)
			break;
	}

	cout<<n<<endl;

	return 0;
}
