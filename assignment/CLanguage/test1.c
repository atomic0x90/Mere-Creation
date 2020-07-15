#include <stdio.h>

int main()
{
	int a = -1,b = -1,c = -1;
	do
	{
		printf("세 변 입력:");
		scanf("%d %d %d",&a,&b,&c);
		
		if(a <= 0 || b <= 0 || c <= 0){
			if(a == 0 && b == 0 && c == 0)
			{
				printf("=> 종료합니다. bye~\n");
				break;
			}
			else
				printf("=> 양수만 입력하세요\n");
		}
		else{
			if(a > b && a > c){
				if(a < b+c)
					printf("=> 올바른 삼각형\n");
				else
					printf("=> 올바르지 않은 삼각형\n");
			}
			else if(b > a && b > c){
				if(b < a+c)
					printf("=> 올바른 삼각형\n");
				else
					printf("=> 올바르지 않은 삼각형\n");
			}
			else if(c > a && c > b){
				if(c < a+b)
					printf("=> 올바른 삼각형\n");
				else
					printf("=> 올바르지 않은 삼각형\n");
			}
		}
	}while(1);
	
	return 0;
}
