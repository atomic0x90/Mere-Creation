#include <stdio.h>

int main()
{
	double r, vol;
	const double PI = 3.141592;
	printf("반지름: ");
	scanf("%lf",&r);
	vol = (4.0*PI*r*r*r)/3.0;
	printf("구의 부피: %lf\n",vol);

	return 0;
}
