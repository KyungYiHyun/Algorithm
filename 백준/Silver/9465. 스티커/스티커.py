T = int(input())
for _ in range(T):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(2)]
    dp = [[0, 0] + [0] * n for _ in range(2)]

    for i in range(n):
        dp[0][i] = max(arr[0][i] + dp[1][i - 1], arr[0][i] + dp[1][i - 2])
        dp[1][i] = max(arr[1][i] + dp[0][i - 1], arr[1][i] + dp[0][i - 2])

    print(max(dp[0][n - 1], dp[1][n - 1]))
