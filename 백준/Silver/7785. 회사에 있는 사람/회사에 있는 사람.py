import sys
n = int(sys.stdin.readline())

dic = {}

for i in range(n):
    name, state = sys.stdin.readline().split()

    dic[name] = state

name_lst = []
for j in dic:
    if dic[j] == 'enter':
        name_lst.append(j)


name_lst.sort(reverse=True)
for k in name_lst:
    print(k)
