#include <iostream>

using namespace std;

int algo(int);

int algo(int i)
{
	if(i < 100)
		return 1;

	if(i == 1000)
		return 0;

	int d1,d2,d3;
	int t1,t2;	//gap
	
	d1 = (i/100)%10;
	d2 = (i/10)%10;
	d3 = i%10;

	t1 = d1 - d2;
	t2 = d2 - d3;

	if(t1 == t2)
		return 1;
	else
		return 0;
}

int main()
{
	int result = 0;
	int num,check;
	cin>>num;

	for(int i = 1;i <= num;i++)
	{
		check = algo(i);

		if(check)
			result++;
	}

	cout<<result<<endl;

	return 0;
}
