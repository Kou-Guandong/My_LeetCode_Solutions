def twoSum(nums, target):
    d = {}
    for i, v in enumerate(nums):
        if target - v in d:
            return [d[target-v], i]
        d[v] = i


print(twoSum([2, 3, 6, 8], 11))  # [1,3]
