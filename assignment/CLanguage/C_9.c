#include <stdio.h>

int main()
{
	int price;
	int cash;
	int tmp;
	int c1000 = 0;
	int c100 = 0;
	int c10 = 0;
	printf("물건 값: ");
	scanf("%d",&price);
	printf("고객님이 내신 돈: ");
	scanf("%d",&cash);

	tmp = cash-price;
	printf("천원: %d장\n",tmp/1000);
	printf("백원: %d개\n",(tmp%1000)/100);
	printf("십원: %d개\n",((tmp%1000)%100)/10);
	
	return 0;
}
