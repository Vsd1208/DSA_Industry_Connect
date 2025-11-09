#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Bst.h"

typedef struct
{
    char roll[20];
    char name[50];
    float cgpa;
} Student;

Tree *root = NULL;

void flushInput(void)
{
    int c;
    while ((c = getchar()) != '\n' && c != EOF)
    {
    }
}

/* Rebuild BST from file so row numbers match file lines (0-based) */
void buildBSTFromFile(const char *filename)
{
    FILE *fp = fopen(filename, "r");
    if (!fp)
        return;

    freeBST(root);
    root = NULL;

    Student s;
    int row = 0;
    while (fscanf(fp, "%19s %49s %f", s.roll, s.name, &s.cgpa) == 3)
    {
        root = insertNode(root, s.roll, row++);
    }
    fclose(fp);
}

/* Create a new file and write N student records */
void createFile(void)
{
    char filename[128];
    printf("Enter new file name: ");
    scanf("%127s", filename);

    FILE *fp = fopen(filename, "w");
    if (!fp)
    {
        perror("fopen");
        return;
    }

    int n;
    printf("Enter number of students: ");
    if (scanf("%d", &n) != 1 || n <= 0)
    {
        printf("Invalid number\n");
        fclose(fp);
        return;
    }
    flushInput();

    Student s;
    for (int i = 0; i < n; ++i)
    {
        printf("Record %d\n", i + 1);
        printf("Enter Roll: ");
        scanf("%19s", s.roll);
        printf("Enter Name: ");
        scanf("%49s", s.name);
        printf("Enter CGPA: ");
        scanf("%f", &s.cgpa);
        fprintf(fp, "%s %s %.2f\n", s.roll, s.name, s.cgpa);
    }

    fclose(fp);
    buildBSTFromFile(filename);
    printf("File '%s' created with %d records.\n", filename, n);
}

/* Append records to an existing file (asks filename) */
void appendFile(void)
{
    char filename[128];
    printf("Enter filename to append: ");
    scanf("%127s", filename);

    FILE *fp = fopen(filename, "a");
    if (!fp)
    {
        printf("Cannot open '%s' for append.\n", filename);
        return;
    }

    int n;
    printf("Enter number of students to append: ");
    if (scanf("%d", &n) != 1 || n <= 0)
    {
        printf("Invalid number\n");
        fclose(fp);
        return;
    }

    Student s;
    for (int i = 0; i < n; ++i)
    {
        printf("Record %d\n", i + 1);
        printf("Enter Roll: ");
        scanf("%19s", s.roll);
        printf("Enter Name: ");
        scanf("%49s", s.name);
        printf("Enter CGPA: ");
        scanf("%f", &s.cgpa);
        fprintf(fp, "%s %s %.2f\n", s.roll, s.name, s.cgpa);
    }

    fclose(fp);
    buildBSTFromFile(filename);
    printf("Appended %d record(s) to '%s'.\n", n, filename);
}

/* Search by roll: rebuild BST from file first */
void searchRecord(void)
{
    char filename[128], roll[20];
    printf("Enter filename to search in: ");
    scanf("%127s", filename);

    buildBSTFromFile(filename);

    printf("Enter roll to search: ");
    scanf("%19s", roll);

    Tree *found = searchNode(root, roll);
    if (!found)
    {
        printf("Record not found.\n");
        return;
    }

    /* read file and print that row */
    FILE *fp = fopen(filename, "r");
    if (!fp)
    {
        printf("Cannot open '%s'.\n", filename);
        return;
    }

    Student s;
    int cur = 0;
    while (fscanf(fp, "%19s %49s %f", s.roll, s.name, &s.cgpa) == 3)
    {
        if (cur == found->row)
        {
            printf("Found (line %d): Roll=%s Name=%s CGPA=%.2f\n", cur + 1, s.roll, s.name, s.cgpa);
            break;
        }
        ++cur;
    }

    fclose(fp);
}

/* Update entire row matched by roll: rebuild BST first */
void updateRecord(void)
{
    char filename[128], roll[20];
    printf("Enter filename to update: ");
    scanf("%127s", filename);

    buildBSTFromFile(filename);

    printf("Enter roll to update: ");
    scanf("%19s", roll);

    Tree *node = searchNode(root, roll);
    if (!node)
    {
        printf("Roll '%s' not found.\n", roll);
        return;
    }

    /* read all records into dynamic array */
    FILE *fp = fopen(filename, "r");
    if (!fp)
    {
        printf("Cannot open '%s' for reading.\n", filename);
        return;
    }

    Student *arr = NULL;
    size_t cap = 0, cnt = 0;
    Student tmp;
    while (fscanf(fp, "%19s %49s %f", tmp.roll, tmp.name, &tmp.cgpa) == 3)
    {
        if (cnt >= cap)
        {
            size_t newcap = (cap == 0) ? 16 : cap * 2;
            Student *narr = realloc(arr, newcap * sizeof(Student));
            if (!narr)
            {
                perror("realloc");
                free(arr);
                fclose(fp);
                return;
            }
            arr = narr;
            cap = newcap;
        }
        arr[cnt++] = tmp;
    }
    fclose(fp);

    if ((size_t)node->row >= cnt)
    {
        printf("Internal error: row out of range.\n");
        free(arr);
        return;
    }

    /* prompt new values (roll,name,cgpa) */
    printf("Enter NEW Roll: ");
    scanf("%19s", arr[node->row].roll);
    printf("Enter NEW Name: ");
    scanf("%49s", arr[node->row].name);
    printf("Enter NEW CGPA: ");
    scanf("%f", &arr[node->row].cgpa);

    /* write back all records */
    fp = fopen(filename, "w");
    if (!fp)
    {
        perror("fopen");
        free(arr);
        return;
    }
    for (size_t i = 0; i < cnt; ++i)
    {
        fprintf(fp, "%s %s %.2f\n", arr[i].roll, arr[i].name, arr[i].cgpa);
    }
    fclose(fp);

    free(arr);
    buildBSTFromFile(filename); /* rebuild to keep BST consistent */
    printf("Record updated successfully.\n");
}

int main(void)
{
    while (1)
    {
        int choice;
        printf("\nMenu:\n");
        printf("1. Create new file\n");
        printf("2. Append to file\n");
        printf("3. Search by roll\n");
        printf("4. Update record by roll\n");
        printf("5. Exit\n");
        printf("Enter choice: ");
        if (scanf("%d", &choice) != 1)
        {
            flushInput();
            continue;
        }

        switch (choice)
        {
        case 1:
            createFile();
            break;
        case 2:
            appendFile();
            break;
        case 3:
            searchRecord();
            break;
        case 4:
            updateRecord();
            break;
        case 5:
            freeBST(root);
            return 0;
        default:
            printf("Invalid choice.\n");
        }
    }
}