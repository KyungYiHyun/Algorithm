from collections import deque
from itertools import combinations


def bfs(lst):
    visited = [[False] * N for _ in range(N)]
    queue = deque()
    t = 0
    for i, j in lst:
        visited[i][j] = True
        queue.append((i, j, t))
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and board[i][j] == 2:
                board[i][j] = 0

    while queue:
        x, y, t = queue.popleft()

        if t >= ans:
            return ans

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if not visited[nx][ny] and board[nx][ny] == 0:
                visited[nx][ny] = True
                queue.append((nx, ny, t + 1))

    for i in range(N):
        for j in range(N):
            if not visited[i][j] and board[i][j] == 0:
                return 2500

    return t


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
ans = 2500
virus = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(N):
    for j in range(N):
        if board[i][j] == 2:
            virus.append((i, j))

candidates = list(combinations(virus, M))

for c in candidates:
    ans = min(ans, bfs(c))

print(-1) if ans == 2500 else print(ans)
