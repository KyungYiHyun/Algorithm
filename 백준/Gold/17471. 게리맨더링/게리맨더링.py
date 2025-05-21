"""
그래프가 주어졌을 때 연결되어 있는 두 구역으로 나누고
두 구역의 최소 인구수 차를 구하자
"""

# 구역이 6개면 1 5 / 2 4 / 3 3
# 7개면 1 6 / 2 5 / 3 4   1 ~ N // 2 까지

from collections import deque


def division(depth, k, start):
    # 구역을 k 와 N - k 개의 구역으로 나누자
    global total

    if depth == k:
        A = []
        B = []
        A_temp = 0
        B_temp = 0
        for j in range(1, N + 1):
            if not visited[j]:
                A.append(j)
            else:
                B.append(j)
        # print(A)
        # print(B)
        # 여기부터 연결되어 있는지 확인하고 연결되어 있으면 인구수 합을 구해주자
        if bfs(A, B, graph) and bfs(B, A, graph):
            for i in A:
                A_temp += populations[i - 1]
            for j in B:
                B_temp += populations[j - 1]
            total = min(abs(A_temp - B_temp), total)
        return

    for i in range(start, N + 1):
        if not visited[i]:
            visited[i] = True
            division(depth + 1, k, i)
            visited[i] = False


def bfs(lst, counter_lst, graph):
    visited2 = [False] * (N + 1)
    check = lst[0]
    queue = deque()
    queue.append(check)
    visited2[check] = True
    for el in counter_lst:
        visited2[el] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited2[i]:
                visited2[i] = True
                queue.append(i)
    for n in lst:
        if visited2[n]:
            continue
        else:
            return False
    else:
        return True


N = int(input())
populations = list(map(int, input().split()))
graph = [[] for _ in range(N + 1)]
for node in range(1, N + 1):
    a, *b = map(int, input().split())
    for e in b:
        graph[node].append(e)
# print(graph)
visited = [False] * (N + 1)
total = 100000000
ans = 100000000
for n in range(1, N // 2 + 1):
    division(0, n, 1)
    ans = min(total, ans)
if ans == 100000000:
    print(-1)
else:
    print(ans)
