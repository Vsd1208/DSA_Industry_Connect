/*File name : LinkedList.h
  Author: Vandanapu Saidhiraj
  Reg No: RA2411003010630
  Created date : 26-09-2025
  Updated by: Vandanapu Saidhiraj
  Updated Date: 06-10-2025
  Copyrights Reserved
*/
#ifndef LINKEDLIST_H
#define LINKEDLIST_H
struct Node
{
  int data;
  struct Node *next;
};
extern struct Node *head;
void Insertatstart(int val);
void Insertatend(int val);
void InsertatMiddle(int value, int position);
void Deleteatstart();
void Deleteatend();
void DeleteatPosition(int position);
void Display();

#endif