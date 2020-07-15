#include <stdio.h>

int main()
{
	int n,tmp = 1;
	printf("정수 입력: ");
	scanf("%d",&n);

	if(n < 0)
		printf("0 이상의 수를 입력하세요.\n");
	else
	{
		for(int i = 1;i <= n;i++)
			tmp *= i;

		printf("%d!은 %d입니다.\n",n,tmp);
	}

	return 0;
}
