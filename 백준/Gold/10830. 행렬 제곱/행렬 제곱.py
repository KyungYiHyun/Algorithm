import sys

input = sys.stdin.readline


def mat_multiple(a, b):
    temp = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                temp[i][j] += a[i][k] * b[k][j]
                temp[i][j] %= 1000
    return temp


def mat_square(n, lst):
    result = [[1 if i == j else 0 for j in range(N)] for i in range(N)]
    base = lst
    while n:
        if n % 2 == 1:
            result = mat_multiple(result, base)
        base = mat_multiple(base, base)
        n //= 2
    return result


N, B = map(int, input().split())

mat = [list(map(int, input().split())) for _ in range(N)]

ans = mat_square(B, mat)

for row in ans:
    print(*row)
