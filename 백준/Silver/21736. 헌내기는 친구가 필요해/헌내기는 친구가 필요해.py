N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

for i in range(N):
    for j in range(M):
        if board[i][j] == 'I':
            start_x = i
            start_y = j

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 0
visited = [[False] * M for _ in range(N)]


def bfs(x, y):
    global result

    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if board[nx][ny] == 'X' and not visited[nx][ny]:
                continue

            if board[nx][ny] == 'P' and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
                result += 1

            if board[nx][ny] == 'O' and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True


bfs(start_x, start_y)

if result:
    print(result)
else:
    print('TT')
