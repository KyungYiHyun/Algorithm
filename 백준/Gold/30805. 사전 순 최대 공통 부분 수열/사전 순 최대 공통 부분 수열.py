def solve(lst_a, lst_b, ans):
    if len(lst_a) == 0 or len(lst_b) == 0:
        return ans

    max_a, max_b = max(lst_a), max(lst_b)
    a_idx, b_idx = lst_a.index(max_a), lst_b.index(max_b)

    if max_a == max_b:
        ans.append(max_a)
        lst_a.pop(a_idx)
        lst_b.pop(b_idx)
        return solve(lst_a[a_idx:], lst_b[b_idx:], ans)

    elif max_a > max_b:
        lst_a.pop(a_idx)
        return solve(lst_a, lst_b, ans)

    elif max_a < max_b:
        lst_b.pop(b_idx)
        return solve(lst_a, lst_b, ans)


N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

rs = solve(A, B, [])
print(len(rs))
print(*rs)
