#include <stdio.h>

void main()
{
    char near *np;
    char far *fp;
    char huge *hp;

    printf("\nSize of near pointer = %d bytes", sizeof(np));
    printf("\nSize of far pointer  = %d bytes", sizeof(fp));
    printf("\nSize of huge pointer = %d bytes", sizeof(hp));
}
