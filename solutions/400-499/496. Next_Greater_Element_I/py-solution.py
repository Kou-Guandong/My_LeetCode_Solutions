class Solution:
    def nextGreaterElement(self, A1, A2):
        stack = []
        store = {}
        for i, v in enumerate(A2):
            while stack and v > stack[-1]:
                store[stack.pop()] = v
            stack.append(v)
        while stack:
            store[stack.pop()] = -1

        return [store[v] for v in A1]
