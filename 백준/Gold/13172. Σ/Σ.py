M = int(input())
MOD = 1000000007
t = 0
for _ in range(M):
    N, S = map(int, input().split())
    t += S * pow(N, (MOD - 2), MOD)
print(t % MOD)
