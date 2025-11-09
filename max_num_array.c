#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10

int arr[MAX];
char strings[MAX][12];

char *toString(int num)
{
    char *str = (char *)malloc(12 * sizeof(char));
    sprintf(str, "%d", num);
    return str;
}

int compare(char a[], char b[])
{
    char ab[24], ba[24];
    strcpy(ab, a);
    strcat(ab, b);
    strcpy(ba, b);
    strcat(ba, a);
    return strcmp(ab, ba);
}

int main()
{
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < n; i++)
        strcpy(strings[i], toString(arr[i]));

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (compare(strings[i], strings[j]) < 0)
            {
                char temp[12];
                strcpy(temp, strings[i]);
                strcpy(strings[i], strings[j]);
                strcpy(strings[j], temp);
            }
        }
    }

    for (int i = 0; i < n; i++)
        printf("%s", strings[i]);

    return 0;
}
