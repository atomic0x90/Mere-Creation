#include <stdio.h>

int main()
{
	int a,check = 0,i,j;
	printf("�� �Է�:");
	scanf("%d",&a);
	
	if(a < 2 || a > 12)
		printf("2~12 ������ ���� �Է��ϼ���. bye~\n");
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
		printf("�� %d���� ����Դϴ�. bye~\n",check);
	}
	
	return 0;
}
