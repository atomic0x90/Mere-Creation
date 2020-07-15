#include <stdio.h>

int main()
{
	int a;
	printf("양의 정수 입력: ");
	scanf("%d",&a);

	int i = 0;
	for(;;)
	{
		a /= 10;
		i++;

		if(a == 0)
			break;
	}
	
	if(i == 1)
		printf("한 자리 숫자입니다.\n");
	else if(i == 2)
		printf("두 자리 숫자입니다.\n");
	else if(i == 3)
		printf("세 자리 숫자입니다.\n");
	else
		printf("네 자리 이상 숫자입니다.\n");

	return 0;
}
