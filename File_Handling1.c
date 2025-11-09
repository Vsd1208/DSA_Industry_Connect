#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef struct
{
    int id;
    char name[50];
    float cgpa;
} Student;

// Function to input student data
void inputStudentData(Student *student)
{
    printf("Enter Student ID: ");
    scanf("%d", &student->id);
    printf("Enter Student Name: ");
    scanf("%s", student->name);
    printf("Enter Student CGPA: ");
    scanf("%f", &student->cgpa);
}

// Function to create a new file (binary)
void newfile()
{
    char filename[50];
    int n;
    Student students[MAX];

    printf("Enter new file name: ");
    scanf("%s", filename);

    FILE *file1 = fopen(filename, "wb"); // binary write
    if (file1 == NULL)
    {
        printf("Error creating file!\n");
        return;
    }

    printf("Enter number of students: ");
    scanf("%d", &n);

    if (n > MAX)
    {
        printf("Limit exceeded! Maximum allowed = %d\n", MAX);
        fclose(file1);
        return;
    }

    for (int i = 0; i < n; i++)
    {
        printf("\nEntering data for student %d:\n", i + 1);
        inputStudentData(&students[i]);
        fwrite(&students[i], sizeof(Student), 1, file1);
    }

    fclose(file1);
    printf("\nFile '%s' created successfully!\n", filename);
}

// Function to update specific record
void updatefile()
{
    char filename[50];
    Student student;
    int row;

    printf("Enter the file name to be updated: ");
    scanf("%s", filename);

    FILE *file2 = fopen(filename, "rb+"); // binary read + write
    if (file2 == NULL)
    {
        printf("Error opening file!\n");
        return;
    }

    printf("Enter record number (starting from 1) to update: ");
    scanf("%d", &row);

    // Move pointer to correct record
    fseek(file2, (row - 1) * sizeof(Student), SEEK_SET);

    printf("\nEnter new student data:\n");
    inputStudentData(&student);

    // Overwrite that record
    fwrite(&student, sizeof(Student), 1, file2);

    fclose(file2);
    printf("Record %d updated successfully!\n", row);
}

// Function to append data
void appendfile()
{
    char filename[50];
    int n;
    Student students[MAX];

    printf("Enter the file name to be appended: ");
    scanf("%s", filename);

    FILE *file3 = fopen(filename, "ab"); // append in binary mode
    if (file3 == NULL)
    {
        printf("Error opening file!\n");
        return;
    }

    printf("Enter number of students to append: ");
    scanf("%d", &n);

    if (n > MAX)
    {
        printf("Limit exceeded! Maximum allowed = %d\n", MAX);
        fclose(file3);
        return;
    }

    for (int i = 0; i < n; i++)
    {
        printf("\nEntering data for student %d:\n", i + 1);
        inputStudentData(&students[i]);
        fwrite(&students[i], sizeof(Student), 1, file3);
    }

    fclose(file3);
    printf("\nData appended successfully to '%s'!\n", filename);
}

// Function to display file contents
void displayfile()
{
    char filename[50];
    Student s;

    printf("Enter filename to display: ");
    scanf("%s", filename);

    FILE *fp = fopen(filename, "rb");
    if (fp == NULL)
    {
        printf("Error opening file!\n");
        return;
    }

    while (fread(&s, sizeof(Student), 1, fp))
        printf("%-10d %-20s %-10.2f\n", s.id, s.name, s.cgpa);

    fclose(fp);
}

int main()
{
    int mode;
    printf("Select Mode:\n1. Create new File\n2. Update File\n3. Append to File\n4. Display File\n");
    scanf("%d", &mode);

    switch (mode)
    {
    case 1:
        newfile();
        break;
    case 2:
        updatefile();
        break;
    case 3:
        appendfile();
        break;
    case 4:
        displayfile();
        break;
    default:
        printf("Invalid mode selected!\n");
    }

    return 0;
}