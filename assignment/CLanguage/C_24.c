#include <stdio.h>

int main()
{
	FILE *fout = fopen("sam.txt","w");

	for(int i = 1;i <= 100;i++)
	{
		if(i % 3 == 0)
			fprintf(fout,"%d\n",i);
	}


	fclose(fout);

	return 0;
}
