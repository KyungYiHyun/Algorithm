board = [list(map(int, input().split())) for _ in range(10)]

paper = [5, 5, 5, 5, 5]
rs = float('inf')


def attach(size, x, y, n):
    for k in range(x, x + size):
        for l in range(y, y + size):
            board[k][l] = n


def check(size, x, y):
    if x + size > 10 or y + size > 10:
        return False
    for i in range(x, x + size):
        for j in range(y, y + size):
            if board[i][j] == 0:
                return False
    return True


def recur(depth):
    global rs

    for i in range(10):
        for j in range(10):
            # print(board)
            if board[i][j] == 1:
                for s in range(1, 6):
                    # print(board)
                    if paper[s - 1] > 0 and check(s, i, j):
                        attach(s, i, j, 0)
                        paper[s - 1] -= 1
                        recur(depth + 1)
                        paper[s - 1] += 1
                        attach(s, i, j, 1)
                return
    rs = min(depth, rs)


recur(0)
if rs == float('inf'):
    print(-1)
else:
    print(rs)
