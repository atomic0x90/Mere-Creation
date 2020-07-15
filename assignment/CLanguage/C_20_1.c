#include <stdio.h>

int main()
{
	double a;
	do{
		printf("실수 입력: ");
		scanf("%lf",&a);

		if(a == 9.9)
		{
			printf("bye~\n");
			break;
		}
	
	}while(1);

	return 0;
}
