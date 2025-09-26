#include <stdio.h>
#include <stdarg.h>
void sum(int count, ...)
{
    int sum = 0;

    va_list args;
    va_start(args, count);

    for (int i = 0; i < count; i++)
    {
        sum += va_arg(args, int);
    }

    va_end(args);

    printf("The sum Inside the method is :: %d\n", sum);
}
int main()
{
    sum(5, 10, 20, 30, 40, 50);
    sum(2, 100, 200);
    return 0;
}