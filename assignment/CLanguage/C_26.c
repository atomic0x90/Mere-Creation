#include <stdio.h>

int main()
{
	FILE *fin = fopen("b.txt","r");
	
	double sum = 0;
	double t;
	for(int i = 0;i < 5;i++)
	{
		fscanf(fin,"%lf",&t);
		sum += t;
	}

	printf("sum: %.4lf\n",sum);

	fclose(fin);

	return 0;
}
