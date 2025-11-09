#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Bst.h"

Tree *createNode(char *rollno, int row)
{
    Tree *n = (Tree *)malloc(sizeof(Tree));
    if (!n)
        return NULL;
    strcpy(n->rollno, rollno);
    n->row = row;
    n->left = n->right = NULL;
    return n;
}

Tree *insertNode(Tree *root, char *rollno, int row)
{
    if (!root)
        return createNode(rollno, row);
    int cmp = strcmp(rollno, root->rollno);
    if (cmp < 0)
        root->left = insertNode(root->left, rollno, row);
    else if (cmp > 0)
        root->right = insertNode(root->right, rollno, row);
    return root;
}

Tree *searchNode(Tree *root, char *rollno)
{
    if (!root)
        return NULL;
    int cmp = strcmp(rollno, root->rollno);
    if (cmp == 0)
        return root;
    if (cmp < 0)
        return searchNode(root->left, rollno);
    return searchNode(root->right, rollno);
}

void freeBST(Tree *root)
{
    if (!root)
        return;
    freeBST(root->left);
    freeBST(root->right);
    free(root);
}
