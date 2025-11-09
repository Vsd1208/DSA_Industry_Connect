#include <stdio.h>

#pragma pack(1) // to avoid padding

struct Student
{

    unsigned int age : 7;
    int rollno;

    unsigned int sex : 1; // 0 for male and 1 for female
};

int main()
{
    struct Student s1 = {10, 2, 0};
    printf("Age: %d\n", s1.age);
    printf("Roll No: %d\n", s1.rollno);
    printf("Sex: %s\n", s1.sex == 0 ? "Male" : "Female");
    printf("%d", sizeof(s1));
    return 0;
}