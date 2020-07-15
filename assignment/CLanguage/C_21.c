#include <stdio.h>

int is_prime(int);
int get_integer(void);
int main()
{
	int n, result;
	n = get_integer();
	result = is_prime(n);
	printf("약수는 총 %d개입니다.\n",result);
	if ( result == 2 )
		printf("==> %d은 소수입니다.\n", n);
	else
		printf("==> %d은 소수가 아닙니다.\n", n);
	return 0;
}

int get_integer(void)
{
	int n;
	printf("정수 입력: "); scanf("%d", &n);
	return n;
}
int is_prime(int n)
{
	int divisors = 0, i;
	for ( i = 1 ; i <= n ; i++ )
	{
		if ( n%i == 0 )
		{
			printf("%d\n",i);
		       	divisors++;
		}
	}
	return divisors;
}
