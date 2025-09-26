#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

int main()
{
    int n;

    printf("Enter the number of elements to be added in the linked list: ");
    scanf("%d", &n);

    for (int count = 0; count < n; count++)
    {
        int value;
        scanf("%d", &value);
        int choice;

        printf("Enter your choice: \n");
        printf("1. Insert at start\n2. Insert at end\n3. Insert at middle\n");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            Insertatstart(value);
            break;
        case 3:
        {
            int position;
            printf("Enter the position to insert the element: ");
            scanf("%d", &position);
            InsertatMiddle(value, position);
        }
        break;
        default:
            Insertatend(value);
            break;
        }
    }

    Display();

    printf("Do you delete any number from the linked list? (1 for yes / 0 for no): ");
    int delChoice;
    scanf("%d", &delChoice);

    switch (delChoice)
    {
    case 1:
    {
        int delchoice;
        printf("1. Delete at start\n2. Delete at end\n3. Delete at Position\n");
        printf("Enter your choice: ");
        scanf("%d", &delchoice);

        switch (delchoice)
        {
        case 1:
            Deleteatstart();
            break;
        case 3:
        {
            int position;
            printf("Enter the position to insert the element: ");
            scanf("%d", &position);
            DeleteatPosition(position);
        }
        break;
        default:
            Deleteatend();
            break;
        }
    }
    break;
    default:
        break;
    }
    Display();
    return 0;
}