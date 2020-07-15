#include <stdio.h>

int main()
{
	FILE *fout = fopen("name.txt","w");

	for(int i = 0;i < 100;i++)
	{
		fprintf(fout,"수지야~\n");
	}

	fclose(fout);

	return 0;
}
