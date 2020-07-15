#include <stdio.h>

int main()
{
	int a,check = 0,i,j;
	printf("수 입력:");
	scanf("%d",&a);
	
	if(a < 2 || a > 12)
		printf("2~12 사이의 수를 입력하세요. bye~\n");
	else
	{
		for(i = 1;i < 7;i++)
		{
			for(j = 1;j < 7;j++)
			{
				if(i + j == a)
				{
					printf("(%d,%d)\n",i,j);
					check++;
				}
			}
		}
		printf("총 %d가지 경우입니다. bye~\n",check);
	}
	
	return 0;
}
