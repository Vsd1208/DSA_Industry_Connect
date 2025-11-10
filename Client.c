#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>
#include <windows.h>

#pragma comment(lib, "ws2_32.lib")

int main(int argc, char *argv[])
{
    WSADATA wsaData;
    WSAStartup(MAKEWORD(2, 2), &wsaData);

    SOCKET sockfd;
    struct sockaddr_in server_addr;
    int a, b, result;
    scanf("%d %d", &a, &b);

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

    char *cmd = argv[1];
    int na = htonl(a);
    int nb = htonl(b);

    send(sockfd, cmd, 4, 0);
    send(sockfd, (char *)&na, sizeof(na), 0);
    send(sockfd, (char *)&nb, sizeof(nb), 0);

    recv(sockfd, (char *)&result, sizeof(result), 0);
    result = ntohl(result);

    printf("RPC result received: %d\n", result);

    closesocket(sockfd);
    WSACleanup();
    return 0;
}
