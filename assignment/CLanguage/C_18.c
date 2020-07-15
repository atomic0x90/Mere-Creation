#include <stdio.h>

int main()
{
	int a,i;
	printf("dan: ");
	scanf("%d",&a);
	for(i = 1;i < 10;i++)
		printf("%d*%d = %d\n",a,i,a*i);

	printf("dan: ");
	scanf("%d",&a);
	i = 1;
	while(i < 10)
	{
		printf("%d*%d = %d\n",a,i,a*i);
		i++;
	}

	printf("dan: ");
	scanf("%d",&a);
	i = 1;
	do{
		printf("%d*%d = %d\n",a,i,a*i);
		i++;
	}while(i < 10);

	printf("종료합니다~\n");
	return 0;
}
