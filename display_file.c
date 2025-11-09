#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int id;
    char name[50];
    float cgpa;
} Student;

void displayStudents(char *filename)
{
    FILE *fp = fopen(filename, "r");
    if (fp == NULL)
    {
        perror("Unable to open file");
        return;
    }

    Student s;
    printf("\n%-10s %-20s %-10s\n", "ID", "Name", "CGPA");
    printf("-------------------------------------------\n");

    // Read text lines formatted as: id name cgpa
    while (fscanf(fp, "%d %s %f", &s.id, s.name, &s.cgpa) == 3)
    {
        printf("%-10d %-20s %-10.2f\n", s.id, s.name, s.cgpa);
    }

    fclose(fp);
}

int main()
{
    char filename[100];
    printf("Enter filename: ");
    scanf("%s", filename);

    displayStudents(filename);
    return 0;
}