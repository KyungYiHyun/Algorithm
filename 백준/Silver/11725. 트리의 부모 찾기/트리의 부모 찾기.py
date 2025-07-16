import sys
sys.setrecursionlimit(100000)

N = int(input())
graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
result = [[] for _ in range(N + 1)]

for i in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


# print(graph)


def dfs(graph, v, visited):
    visited[v] = True
    # print('visited',visited)
    for i in graph[v]:
        if not visited[i]:
            result[i] = v
            # print(i)
            visited[i] = True
            dfs(graph, i, visited)


dfs(graph, 1, visited)
for i in range(2, N + 1):
    print(result[i])
