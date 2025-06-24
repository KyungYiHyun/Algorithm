T = int(input())

DP = [[0] * 15 for _ in range(15)]

for i in range(1, 15):
    DP[0][i] = DP[0][i - 1] + 1

for j in range(1, 15):
    for k in range(15):
        DP[j][k] = sum(DP[j - 1][0: k + 1])

for _ in range(T):
    n = int(input())
    k = int(input())
    print(DP[n][k])
