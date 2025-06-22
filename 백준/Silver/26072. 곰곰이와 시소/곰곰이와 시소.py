N, L = map(int, input().split())
location = list(map(int, input().split()))
weight = list(map(int, input().split()))
start = 0
end = L

while end - start > 1e-6:
    mid = (start + end) / 2
    left_sum = 0
    right_sum = 0
    for i in range(N):
        if location[i] < mid:
            left_sum += (mid - location[i]) * weight[i]
        elif location[i] >= mid:
            right_sum += (location[i] - mid) * weight[i]
    if left_sum >= right_sum:
        end = mid
    elif left_sum < right_sum:
        start = mid

print(mid)
