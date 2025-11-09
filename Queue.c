#include <stdio.h>
#include "Queue.h"
#include "LinkedList.h"

void enqueue()
{
    int data;
    printf("Enter data to insert: ");
    scanf("%d", &data);
    Insertatend(data);
}

void dequeue()
{
    Deleteatstart();
}

void display()
{
    Display();
}
