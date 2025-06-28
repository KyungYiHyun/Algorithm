N = int(input())
eggs = []
ans = 0
for _ in range(N):
    d, w = map(int, input().split())
    eggs.append([d, w])


def dfs(depth):
    global ans

    if depth == N:
        cnt = 0
        for j in range(N):
            if eggs[j][0] <= 0:
                cnt += 1
        ans = max(ans, cnt)
        return

    if eggs[depth][0] <= 0:
        dfs(depth + 1)
    else:
        check = False
        for i in range(N):
            if i != depth and eggs[i][0] > 0:
                check = True
                eggs[depth][0] -= eggs[i][1]
                eggs[i][0] -= eggs[depth][1]
                dfs(depth + 1)
                eggs[depth][0] += eggs[i][1]
                eggs[i][0] += eggs[depth][1]

        if not check:
            ans = max(ans, N - 1)
            return


dfs(0)
print(ans)
