#include <stdio.h>
#include <stdlib.h>

int add(int a, int b)
{
    return a + b;
}

int subtract(int a, int b)
{
    return a - b;
}

void result(int (*fp)(int, int), int (*fp2)(int, int), int x, int y)
{
    printf("Addition Result: %d\n", fp(x, y));
    printf("Subtraction Result: %d\n", fp2(x, y));
}

int main(int argc, char *argv[])
{
    int a = atoi(argv[1]);
    int b = atoi(argv[2]);
    int (*fp)(int, int);
    fp = &add;
    int (*fp2)(int, int);
    fp2 = &subtract;
    result(fp, fp2, a, b);
    return 0;
}