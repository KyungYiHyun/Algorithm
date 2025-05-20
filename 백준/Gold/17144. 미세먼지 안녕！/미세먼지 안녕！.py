def diffusion():
    copy_board = [i[:] for i in board]

    for i in range(R):
        for j in range(C):
            if board[i][j] and board[i][j] != -1:
                amount = copy_board[i][j] // 5
                cnt = 0
                for k in range(4):
                    ni = i + dx[k]
                    nj = j + dy[k]
                    if ni < 0 or ni >= R or nj < 0 or nj >= C or board[ni][nj] == -1:
                        continue
                    board[ni][nj] += amount
                    cnt += 1
                board[i][j] -= amount * cnt


def rotate():
    copy_board = [i[:] for i in board]
    check = True

    for i in range(R):
        for j in range(C):
            if board[i][j] == -1 and check:
                check = False
                for k in range(1, C - 1):
                    board[i][k + 1] = copy_board[i][k]
                    board[i][1] = 0
                for l in range(i - 1, -1, -1):
                    board[l][-1] = copy_board[l + 1][-1]
                for v in range(C - 2, -1, -1):
                    board[0][v] = copy_board[0][v + 1]
                for c in range(1, i):
                    board[c][0] = copy_board[c - 1][0]
            elif board[i][j] == -1 and not check:
                for k in range(1, C - 1):
                    board[i][k + 1] = copy_board[i][k]
                    board[i][1] = 0
                for l in range(i + 1, R):
                    board[l][-1] = copy_board[l - 1][-1]
                for v in range(C - 2, -1, -1):
                    board[R - 1][v] = copy_board[R - 1][v + 1]
                for c in range(R - 2, i, -1):
                    board[c][0] = copy_board[c + 1][0]


R, C, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(T):
    diffusion()
    rotate()

ans = sum(map(sum, board)) + 2
print(ans)
