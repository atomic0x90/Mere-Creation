#include <stdio.h>

int main()
{
	int a = -1,b = -1,c = -1;
	do
	{
		printf("�� �� �Է�:");
		scanf("%d %d %d",&a,&b,&c);
		
		if(a <= 0 || b <= 0 || c <= 0){
			if(a == 0 && b == 0 && c == 0)
			{
				printf("=> �����մϴ�. bye~\n");
				break;
			}
			else
				printf("=> ����� �Է��ϼ���\n");
		}
		else{
			if(a > b && a > c){
				if(a < b+c)
					printf("=> �ùٸ� �ﰢ��\n");
				else
					printf("=> �ùٸ��� ���� �ﰢ��\n");
			}
			else if(b > a && b > c){
				if(b < a+c)
					printf("=> �ùٸ� �ﰢ��\n");
				else
					printf("=> �ùٸ��� ���� �ﰢ��\n");
			}
			else if(c > a && c > b){
				if(c < a+b)
					printf("=> �ùٸ� �ﰢ��\n");
				else
					printf("=> �ùٸ��� ���� �ﰢ��\n");
			}
		}
	}while(1);
	
	return 0;
}
