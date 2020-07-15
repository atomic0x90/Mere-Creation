#include <stdio.h>

int main()
{
	int a[3] = {10,20,30};
	int b[3];
	int check = 0;

	for(int i = 0;i < 3;i++)
	{
		printf("%d번째 숫자 입력:",i+1);
		scanf("%d",&b[i]);
	}

	for(int i = 0;i < 3;i++)
	{
		if(a[i] != b[i])
		{
			check++;
			break;
		}
	}

	if(check == 0)
		printf("똑같습니다~\n");
	else
		printf("다릅니다~\n");

	return 0;
}
