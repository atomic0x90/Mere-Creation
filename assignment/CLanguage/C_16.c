#include <stdio.h>

int main()
{
	int n,sum = 0,tmp;

	printf("정수 입력: ");
	scanf("%d",&n);

	if(n > 0)
	{
		for(int i = 0;i < n;i++)
		{
			scanf("%d",&tmp);
			sum += tmp;
		}
		printf("sum: %d\n",sum);
	}
	else
		printf("sum: 0\n");

	return 0;
}
