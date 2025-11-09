#include <stdio.h>

// typedef struct {
//     int fd;			/* File descriptor */
//     unsigned char *buf;	/* Buffer */
//     size_t size;		/* Size of the file */
//     size_t pos;		/* Current position in the file */
//  } FILE;
//  structure of FILE in stdio.h

int main()
{
    FILE *fptr;
    fptr = fopen("filec.txt", "a");
    if (fptr == NULL)
    {
        printf("Error");
        return 1;
    }
    fprintf(fptr, "Saidhiraj\n");
    fclose(fptr);
    return 0;
}