a, b = map(int,input().split())
six = []
one = []
for i in range(b):
    num1, num2 = map(int, input().split())
    six.append(num1)
    one.append(num2)

six.sort()
one.sort()

if (a % 6 == 0):
    first = a // 6
    second1 = a // 6
    second2 = 0
else:
    first = a // 6 + 1
    second1 = a // 6
    second2 = a % 6

third = a

ans1 = six[0] * first
ans2 = six[0] * second1 + one[0] * second2
ans3 = one[0] * third

sol = min(ans1, ans2, ans3)
print(sol)