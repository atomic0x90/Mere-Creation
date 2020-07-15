#include <stdio.h>

int main()
{
	int a,b,c;

	printf("삼각형의 3변을 입력하시오: ");
	scanf("%d%d%d",&a,&b,&c);

	if(a <= 0 || b <= 0 || c <= 0)
		printf("세 각은 양수여야 합니다.\n");
	else
	{
		if(a + b + c == 180)
			printf("올바른 삼각형\n");
		else
			printf("세 각의 합은 180도여야 합니다\n");
	}

	return 0;
}
