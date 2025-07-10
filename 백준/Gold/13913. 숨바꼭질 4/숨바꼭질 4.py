from collections import deque

N, K = map(int, input().split())
visited = [0] * 100001
parent = [None] * 100001


def bfs():
    queue = deque()
    queue.append((N, 0))
    visited[N] = True

    while queue:
        l, cnt = queue.popleft()
        if l == K:
            return cnt
        next_l = l * 2
        if 0 <= next_l <= 100000 and not visited[next_l]:
            visited[next_l] = True
            parent[next_l] = l
            queue.append((next_l, cnt + 1))

        next_l_2 = l - 1
        if 0 <= next_l_2 <= 100000 and not visited[next_l_2]:
            visited[next_l_2] = True
            parent[next_l_2] = l
            queue.append((next_l_2, cnt + 1))

        next_l_3 = l + 1
        if 0 <= next_l_3 <= 100000 and not visited[next_l_3]:
            visited[next_l_3] = True
            parent[next_l_3] = l
            queue.append((next_l_3, cnt + 1))


print(bfs())

current = K
path = []

while current is not None:
    path.append(current)
    current = parent[current]
path.reverse()
print(*path)
