s = input()
t = input()

chk = False


def back(a, depth):
    global chk

    if (a not in t and a[::-1] not in t):
        return

    if depth == len(t) + 1:
        return
    if a == t:
        chk = True
        return

    a += 'A'
    back(a, depth + 1)
    a = a[:-1]
    a += 'B'
    a = a[::-1]
    back(a, depth + 1)
    a = a[::-1]
    a = a[:-1]


back(s, len(s))
if chk:
    print(1)
else:
    print(0)
