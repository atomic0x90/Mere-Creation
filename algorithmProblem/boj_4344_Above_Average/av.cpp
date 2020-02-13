#include <iostream>

#include <cstring>

using namespace std;

int main()
{
	int testCase,sum;
	int n,sc[1001];
	double average,over;

	cin>>testCase;

	while(testCase)
	{
		sum = over = 0;

		memset(sc,0,sizeof(sc));

		cin>>n;
		
		for(int i = 0;i < n;i++)
		{
			cin>>sc[i];
			sum += sc[i];
		}

		average = sum / n;
	
		for(int i = 0;i < n;i++)
		{
			if(average < sc[i])
				over++;
		}

		cout<<fixed;
		cout.precision(3);

		cout<<over/n * 100<<"%\n";

		testCase--;
	}

	return 0;
}
