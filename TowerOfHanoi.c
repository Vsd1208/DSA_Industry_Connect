#include <stdio.h>

void TowerofHanoi(int n, int source, int destination, int auxiliary)
{
    if (n == 1)
    {
        printf("Move disk 1 from rod %d to rod %d\n", source, destination);
        return;
    }

    TowerofHanoi(n - 1, source, auxiliary, destination);

    printf("Move disk %d from rod %d to rod %d\n", n, source, destination);

    TowerofHanoi(n - 1, auxiliary, destination, source);
}

int main()
{
    int n;
    printf("Enter the number of disks: ");
    scanf("%d", &n);
    TowerofHanoi(n, 1, 3, 2);
    return 0;
}