#include <stdio.h>
#include <math.h>

int main()
{
	double a,b,c;
	printf("계수 a를 입력하시오: ");
	scanf("%lf",&a);
	printf("계수 b를 입력하시오: ");
	scanf("%lf",&b);
	printf("계수 c를 입력하시오: ");
	scanf("%lf",&c);

	if(a == 0)
	{
		if(b == 0)
			printf("방정식이 아닙니다.\n");
		else
			printf("방정식의 근은 %g입니다.\n", -c/b);
	}
	else
	{
		if( (b*b - 4.0*a*c) > 0)
		{
			printf("방정식의 근은 %g입니다.\n",(-b+sqrt(b*b-4.0*a*c))/(2.0*a));
			printf("방정식의 근은 %g입니다.\n",(-b-sqrt(b*b-4.0*a*c))/(2.0*a));
		}
		else if( (b*b - 4.0*a*c) == 0)
			printf("방정식의 근은 %g입니다.\n",(-b)/(2.0*a));
		else
			printf("실근이 존재하지 않습니다.\n");
	}
	return 0;
}
