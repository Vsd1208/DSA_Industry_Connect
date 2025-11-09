#ifndef BST_H
#define BST_H

typedef struct Tree
{
    char rollno[20];
    int row;
    struct Tree *left;
    struct Tree *right;
} Tree;

Tree *createNode(char *rollno, int row);
Tree *insertNode(Tree *root, char *rollno, int row);
Tree *searchNode(Tree *root, char *rollno);
void freeBST(Tree *root);

#endif