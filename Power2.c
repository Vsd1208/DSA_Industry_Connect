#include <stdio.h>

// is power of 2

int main()
{
    int num;
    int a = 2;
    scanf("%d", &num);
    if (((num & (num - 1)) == 0) && (num > 0)) // for 16 10000 and 15 01111
        printf("Power of 2");
    else
        printf("Not a power of 2");
    return 0;
}
// 1
// 10
// 1000
// 10000
// 100000