#include <stdio.h>

int main()
{
	int a,b,c,max;

	printf("세 수 입력 : ");
	scanf("%d %d %d",&a,&b,&c);
	if(a >= b)
	{
		if(a >= c)
			max = a;
		else
			max = c;
	}
	else if(b >= a)
	{
		if(b >= c)
			max = b;
		else
			max = c;
	}

	printf("최대값: %d\n",max);

	return 0;
}
