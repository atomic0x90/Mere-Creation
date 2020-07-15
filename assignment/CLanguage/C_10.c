#include <stdio.h>

int main()
{
	double tmp;
	printf("섭씨온도를 입력하세요: ");
	scanf("%lf",&tmp);
	printf("화씨온도는 %.2lf입니다.\n",tmp*(9.0/5.0) + 32);

	return 0;
}
