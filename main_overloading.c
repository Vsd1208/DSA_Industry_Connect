#include <stdio.h>
#include <stdlib.h>

// main method parameter passing

int main(int argc, char *argv[]) // argc counts number of arguments passed through command line
{
    printf("%d\n", argv[1]);
    printf("%s", argv[1]);

    int num1 = atoi(argv[1]); // converting string to integer
    int num2 = atoi(argv[3]);

    switch (*argv[2]) // argv[2] is the operator passed through command line
    {
    case '+':
        printf("\nSum of two numbers :: %d", num1 + num2);
        break;
    case '-':
        printf("\nDifference of two numbers :: %d", num1 - num2);
        break;
    case '*':
        printf("\nProduct of two numbers :: %d", num1 * num2);
        break;
    case '/':
        printf("\nQuotient of two numbers :: %d", num1 / num2);
        break;
    default:
        printf("\nInvalid operator");
        break;
    }
    return 0;
}
// public static void main(String[] args)