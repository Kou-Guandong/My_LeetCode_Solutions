class Solution:
    def nextGreaterElements(A):
        n = len(A)
        res = [-1] * n
        stack = []
        for i, v in enumerate(A + A):
            while stack and v > A[stack[-1] % n]:
                res[stack.pop()] = v
            if not stack:
                res[i] = -1
            stack.append(i % n)
        return res