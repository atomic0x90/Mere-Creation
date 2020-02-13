#include <iostream>

using namespace std;

int main()
{
	int n , max = 0 , a;
	double tmp[1001] , sum = 0;

	cin>>n;

	for(int i = 0;i < n;i++)
	{
		cin>>a;

		if(a > max)
			max = a;

		tmp[i] = a;
	}

	for(int i = 0;i < n;i++)
		tmp[i] = tmp[i] / max * 100;

	for(int i = 0;i < n;i++)
		sum += tmp[i];

	cout<<fixed;
	cout.precision(10);

	cout<<sum/n<<endl;

	return 0;
}
