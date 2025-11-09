#include <stdio.h>

int main()
{
    printf("\033[2J");   // Clear screen
    printf("\033[1;1H"); // Move cursor to row 1, column 1 (top-left)
    printf("X");
    return 0;
}