#include <stdio.h>

int main()
{
	for(int i = 1;i < 10;i++)
	{
		for(int j = 1;j < 10;j++)
			printf("%d*%d=%2d  ",j,i,i*j);
		
		printf("\n");
	}

	printf("\n");
	int i = 1,j = 1;
	while(i < 10)
	{
		while(j < 10)
		{
			printf("%d*%d=%2d  ",j,i,i*j);
			j++;
		}
		printf("\n");
	
		j = 1;
		i++;
	}

	return 0;
}
