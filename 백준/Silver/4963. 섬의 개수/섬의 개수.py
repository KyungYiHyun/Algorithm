"""
1. 아이디어
- 방향 8개 설정, bfs를 돌며 1이 끊길 때마다 카운트를 욜려준다.
2. 시간복잡도
-
3. 자료구조
- 방향 벡터 리스트
"""

from collections import deque

dx = [1, -1, 0, 0, -1, 1, 1, -1]  # 상 하 좌 우 대각선
dy = [0, 0, -1, 1, 1, 1, -1, -1]


def bfs(x, y):
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                continue
            if board[nx][ny] == 0:
                continue
            if board[nx][ny] == 1:
                board[nx][ny] = 0
                queue.append((nx, ny))
    return 


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    board = [list(map(int, input().split())) for _ in range(h)]
    queue = deque()

    result = 0

    for i in range(h):
        for j in range(w):
            if board[i][j] == 1:
                bfs(i , j)
                result += 1

    print(result)
