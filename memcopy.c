#include <stdio.h>
void memcopy(char *dest, char *src, int n)
{
    char *start = dest;
    while (n--)
    {
        *dest++ = *src++;
    }
    *dest = '\0';
    printf("%s\n", start);
}
int main()
{
    char source[] = "Helloworld";
    char destination[10];
    memcopy(destination, source, 5);
    return 0;
}