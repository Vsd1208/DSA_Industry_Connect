#ifndef LINKEDLIST_H
#define LINKEDLIST_H
struct Node
{
    int data;
    struct Node *next;
};

void Insertatstart(int val);
void Insertatend(int val);
void InsertatMiddle(int value, int position);
void Deleteatstart();
void Deleteatend();
void DeleteatPosition(int position);
void Display();

#endif