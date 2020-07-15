#include <stdio.h>

void Hanjul(char,int);

int main()
{
	Hanjul('*',10);
	Hanjul('!',5);
	Hanjul('@',3);

	return 0;
}

void Hanjul(char c,int a)
{
	for(int i = 0;i < a;i++)
		printf("%c",c);
	printf("\n");

	return;
}
