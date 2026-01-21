#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

typedef struct Node
{
    int data;
    struct Node *npx;
} Node;

Node *XOR(Node *a, Node *b)
{
    return (Node *)((uintptr_t)(a) ^ (uintptr_t)(b)); // uintptr_t for pointer arithmetic,conerts pointer to integer type
}

void insert(Node **head, int data)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;

    newNode->npx = XOR(NULL, *head);

    if (*head != NULL)
    {
        Node *next = XOR(NULL, (*head)->npx);
        (*head)->npx = XOR(newNode, next);
    }

    *head = newNode;
}

void traverse(Node *head)
{
    Node *curr = head;
    Node *prev = NULL;
    Node *next;

    printf("XOR DLL Forward: ");
    while (curr != NULL)
    {
        printf("%d ", curr->data);
        next = XOR(prev, curr->npx);
        prev = curr;
        curr = next;
    }
    printf("\n");
}

int main()
{
    Node *head = NULL;

    insert(&head, 10);
    insert(&head, 20);
    insert(&head, 30);

    traverse(head);

    return 0;
}