#include <stdio.h>

void tmp(int *a,int *b,int *c)
{
	int t1 = *a, t2 = *b, t3 = *c;
	
	*a = *c;
	*b = *a;
	*c = *b;
	
	*a = t3;
	*b = t1;
	*c = t2;
	
	return;
}

int main()
{
	int a,b,c;
	printf("�� �� �Է�: ");
	scanf("%d %d %d",&a,&b,&c);
	
	tmp(&a,&b,&c);
	printf("�ڸ� �̵� ��� --> %d %d %d",a,b,c);
	return 0;
}
