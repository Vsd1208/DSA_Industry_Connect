#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode
{
    int data;
    struct ListNode *next;
} ListNode;

int main()
{
    int n;
    scanf("%d", &n);

    ListNode *head = NULL, *tail = NULL;
    for (int i = 0; i < n; i++)
    {
        ListNode *newNode = malloc(sizeof(ListNode));
        scanf("%d", &newNode->data);
        newNode->next = NULL;

        if (head == NULL)
            head = tail = newNode;
        else
            tail = tail->next = newNode;
    }
    ListNode *newHead = NULL, *newTail = NULL;

    ListNode *current = head;
    while (current != NULL)
    {
        if (current->data % 2 == 0)
        {
            if (newHead == NULL)
                newHead = newTail = current;
            else
            {
                newTail->next = current;
                newTail = current;
            }
        }
        current = current->next;
    }

    current = head;
    while (current != NULL)
    {
        if (current->data % 2 != 0)
        {
            if (newHead == NULL)
                newHead = newTail = current;
            else
            {
                newTail->next = current;
                newTail = current;
            }
        }
        current = current->next;
    }
    if (newTail != NULL)
        newTail->next = NULL;

    current = newHead;
    while (current != NULL)
    {
        printf("%d ", current->data);
        current = current->next;
    }

    return 0;
}
