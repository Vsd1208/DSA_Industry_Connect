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
        ListNode *newNode = (ListNode *)malloc(sizeof(ListNode));
        scanf("%d", &newNode->data);
        newNode->next = NULL;

        if (head == NULL)
        {
            head = tail = newNode;
        }
        else
        {
            tail->next = newNode;
            tail = newNode;
        }
    }
    ListNode *evenHead = NULL, *eventemp = NULL;
    ListNode *oddHead = NULL, *oddtemp = NULL;

    ListNode *current = head;
    while (current != NULL)
    {
        if (current->data % 2 == 0)
        {
            if (evenHead == NULL)
                evenHead = eventemp = current;
            else
            {
                eventemp->next = current;
                eventemp = current;
            }
        }
        else
        {
            if (oddHead == NULL)
                oddHead = oddtemp = current;
            else
            {
                oddtemp->next = current;
                oddtemp = current;
            }
        }
        current = current->next;
    }
    if (eventemp != NULL)
        eventemp->next = oddHead;

    if (oddtemp != NULL)
        oddtemp->next = NULL;
    head = (evenHead != NULL) ? evenHead : oddHead;
    current = head;
    while (current != NULL)
    {
        printf("%d ", current->data);
        current = current->next;
    }

    return 0;
}
