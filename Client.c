/* RPC Client - Sends arithmetic operation to Server
   Author: Vandanapu Saidhiraj
   Date: 10-11-2025
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>
#include <windows.h>

#pragma comment(lib, "ws2_32.lib")

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: client <cmd>\nCommands: add, sub, mul, div\n");
        return 1;
    }

    char cmd_buf[5]; // 4 chars + null terminator
    memset(cmd_buf, 0, sizeof(cmd_buf));
    strncpy(cmd_buf, argv[1], 4);

    int a, b, result;

    printf("Enter two numbers: ");
    scanf("%d %d", &a, &b);

    WSADATA wsaData;
    WSAStartup(MAKEWORD(2, 2), &wsaData);

    SOCKET sockfd;
    struct sockaddr_in server_addr;

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd == INVALID_SOCKET)
    {
        printf("Socket creation failed\n");
        WSACleanup();
        return 1;
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(9000);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) == SOCKET_ERROR)
    {
        printf("Connection failed\n");
        closesocket(sockfd);
        WSACleanup();
        return 1;
    }

    int na = htonl(a);
    int nb = htonl(b);

    send(sockfd, cmd_buf, sizeof(cmd_buf), 0);
    send(sockfd, (char *)&na, sizeof(na), 0);
    send(sockfd, (char *)&nb, sizeof(nb), 0);

    recv(sockfd, (char *)&result, sizeof(result), 0);
    result = ntohl(result);

    printf("RPC result received: %d\n", result);

    closesocket(sockfd);
    WSACleanup();
    return 0;
}

// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <winsock2.h>
// #include <windows.h>

// //10.9.57.188
// #pragma comment(lib, "ws2_32.lib")

// int main(int argc, char *argv[])
// {
//     if (argc < 3)
//     {
//         printf("Usage: client <cmd>\nCommands: add, sub, mul, div\n");
//         return 1;
//     }

//     char cmd_buf[5]; // 4 chars + null terminator
//     memset(cmd_buf, 0, sizeof(cmd_buf));
//     strncpy(cmd_buf, argv[2], 4);

//     int a, b, result;

//     printf("Enter two numbers: ");
//     scanf("%d %d", &a, &b);

//     WSADATA wsaData;
//     WSAStartup(MAKEWORD(2, 2), &wsaData);

//     SOCKET sockfd;
//     struct sockaddr_in server_addr;

//     sockfd = socket(AF_INET, SOCK_STREAM, 0);
//     if (sockfd == INVALID_SOCKET)
//     {
//         printf("Socket creation failed\n");
//         WSACleanup();
//         return 1;
//     }

//     server_addr.sin_family = AF_INET;
//     server_addr.sin_port = htons(9000);
//     server_addr.sin_addr.s_addr = inet_addr(argv[1]);

//     if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) == SOCKET_ERROR)
//     {
//         printf("Connection failed\n");
//         closesocket(sockfd);
//         WSACleanup();
//         return 1;
//     }

//     int na = htonl(a);
//     int nb = htonl(b);

//     send(sockfd, cmd_buf, sizeof(cmd_buf), 0);
//     send(sockfd, (char *)&na, sizeof(na), 0);
//     send(sockfd, (char *)&nb, sizeof(nb), 0);

//     recv(sockfd, (char *)&result, sizeof(result), 0);
//     result = ntohl(result);

//     printf("RPC result received: %d\n", result);

//     closesocket(sockfd);
//     WSACleanup();
//     return 0;
// }