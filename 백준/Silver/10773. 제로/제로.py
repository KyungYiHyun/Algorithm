import sys
from collections import deque

K = int(input())

stack = deque()

for _ in range(K):
    num = int(sys.stdin.readline())
    if num == 0:
        stack.pop()
    else:
        stack.append(num)
print(sum(stack))

