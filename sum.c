#include <stdio.h>
// #define DEBUG
int main()
{
#ifdef DEBUG
    printf("Entered into main method");
#endif
    int a = 5;
    int b = 10;
    int sum = a + b;
    printf("Sum: %d\n", sum);

#ifdef DEBUG
    printf("EXECETING THE main method");
#endif
    return 0;
}