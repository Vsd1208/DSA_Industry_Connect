#include <stdio.h>
#include <stdlib.h>
#include "Stack.h"

int main()
{
    int n;

    printf("Enter the number of elements in the stack: ");
    scanf("%d", &n);

    for (int count = 0; count < n; count++)
    {
        int value;
        scanf("%d", &value);
        int choice;

        push(value);
    }
    display();

    printf("Do you delete any number from the Stack? (1 for yes / 0 for no): ");
    int delChoice;
    scanf("%d", &delChoice);

    switch (delChoice)
    {
    case 1:
    {
        pop();
    }
    break;
    default:
        break;
    }

    display();
    return 0;
}