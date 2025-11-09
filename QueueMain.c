#include <stdio.h>
#include "Queue.h"

int main()
{
    int n;
    printf("Enter the number of elements in the Queue: ");
    scanf("%d", &n);

    for (int count = 0; count < n; count++)
    {
        enqueue();
    }
    display();

    printf("Do you delete any number from the Queue? (1 for yes / 0 for no): ");
    int delChoice;
    scanf("%d", &delChoice);

    switch (delChoice)
    {
    case 1:
    {
        dequeue();
    }
    break;
    default:
        break;
    }

    display();
    return 0;
}
