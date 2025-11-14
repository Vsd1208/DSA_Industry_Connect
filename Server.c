/* RPC Server - Arithmetic Operations
   Author: Vandanapu Saidhiraj
   Date: 10-11-2025
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>
#include <ws2tcpip.h>

#pragma comment(lib, "ws2_32.lib")

int operations(const char *cmd, int a, int b)
{
    if (strcmp(cmd, "add") == 0)
        return a + b;
    if (strcmp(cmd, "sub") == 0)
        return a - b;
    if (strcmp(cmd, "mul") == 0)
        return a * b;
    if (strcmp(cmd, "div") == 0)
        return (b != 0 ? a / b : 0);
    return 0;
}

int main()
{
    WSADATA wsaData;
    WSAStartup(MAKEWORD(2, 2), &wsaData);

    SOCKET server_fd, client_fd;
    struct sockaddr_in addr, clientAddr;
    int addrLen = sizeof(clientAddr);

    char cmd[5]; // 4 chars + null
    int a, b, result;

    server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd == INVALID_SOCKET)
    {
        printf("Socket creation failed\n");
        return 1;
    }

    addr.sin_family = AF_INET;
    addr.sin_addr.s_addr = INADDR_ANY;
    addr.sin_port = htons(9000);

    if (bind(server_fd, (struct sockaddr *)&addr, sizeof(addr)) == SOCKET_ERROR)
    {
        printf("Bind failed\n");
        closesocket(server_fd);
        WSACleanup();
        return 1;
    }

    if (listen(server_fd, 1) == SOCKET_ERROR)
    {
        printf("Listen failed\n");
        closesocket(server_fd);
        WSACleanup();
        return 1;
    }

    printf("Server running... Waiting for RPC client.\n");

    client_fd = accept(server_fd, (struct sockaddr *)&clientAddr, &addrLen);
    if (client_fd == INVALID_SOCKET)
    {
        printf("Accept failed\n");
        closesocket(server_fd);
        WSACleanup();
        return 1;
    }

    memset(cmd, 0, sizeof(cmd));
    recv(client_fd, cmd, sizeof(cmd), 0);

    recv(client_fd, (char *)&a, sizeof(a), 0);
    recv(client_fd, (char *)&b, sizeof(b), 0);

    a = ntohl(a);
    b = ntohl(b);

    result = operations(cmd, a, b);
    result = htonl(result);

    send(client_fd, (char *)&result, sizeof(result), 0);

    printf("Operation '%s' performed on (%d, %d). Result = %d\n",
           cmd, a, b, ntohl(result));

    closesocket(client_fd);
    closesocket(server_fd);
    WSACleanup();

    return 0;
}
