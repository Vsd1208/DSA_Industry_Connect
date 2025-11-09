#include <stdio.h>
#include <stdlib.h>

#define ROW 100
#define MAX 100

typedef struct // Student structure
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

// Function to create a new file and write student data
void newfile()
{
    char filename[50];
    int n;
    Student students[MAX];

    printf("Enter new file name: ");
    scanf("%s", filename);

    FILE *file1 = fopen(filename, "w");
    if (file1 == NULL)
    {
        printf("Error opening file!\n");
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
        fprintf(file1, "%d  %s  %.2f\n", students[i].id, students[i].name, students[i].cgpa);
    }

    fclose(file1);
    printf("\nFile '%s' created successfully!\n", filename);
}

// Function to update specific row and column (illustrative)
void updatefile()
{
    char filename[50];
    Student student;
    int row;

    printf("Enter the file name to be updated: ");
    scanf("%s", filename);

    FILE *file2 = fopen(filename, "rb+"); // read + write
    if (file2 == NULL)
    {
        printf("Error opening file!\n");
        return;
    }

    printf("Enter row and column to update (row col): ");
    scanf("%d", &row);

    printf("\nEnter new student data:\n");
    inputStudentData(&student);

    // Move file pointer — only symbolic in text mode
    fseek(file2, (row - 1) * sizeof(Student), SEEK_SET);
    fwrite(&student, sizeof(Student), 1, file2);

    fclose(file2);
    printf("Data updated successfully!\n");
}

// Function to append data to existing file
void appendfile()
{
    char filename[50];
    int n;
    Student students[MAX];

    printf("Enter the file name to be appended: ");
    scanf("%s", filename);

    FILE *file3 = fopen(filename, "a"); // append mode
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
        fprintf(file3, "%d  %s  %.2f\n", students[i].id, students[i].name, students[i].cgpa);
    }

    fclose(file3);
    printf("\nData appended successfully to '%s'!\n", filename);
}

int main()
{
    int mode;
    printf("Select Mode:\n1. Create new File\n2. Update File\n3. Append to File\n");
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
    default:
        printf("Invalid mode selected!\n");
    }

    return 0;
}