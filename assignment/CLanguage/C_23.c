#include <stdio.h>

int sum(int,int);

int main()
{
	int a,b,i;
	printf("두 수 입력: ");
	scanf("%d %d", &a, &b);
	printf("%d부터 %d사이의 모든 수의 합 -> %d \n", a, b, sum(a,b));
	return 0;
}

int sum(int a,int b)
{
	if(a >= b)
		return 0;

	int t = 0;
	for(int i = a;i <= b;i++)
		t += i;

	return t;
}
