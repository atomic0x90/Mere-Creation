#include <stdio.h>

int main()
{
	int a[10] = {100,80,90,70,100,10,0,40,50,60};
	int check1 = 0,check2 = 0;

	for(int i = 0;i < 10;i++)
	{
		if(a[i] == 100)
			check1++;
		else if(a[i] < 60)
			check2++;
	}
	printf("100점만점 %d명, 낙제 %d명\n",check1,check2);

	return 0;
}
