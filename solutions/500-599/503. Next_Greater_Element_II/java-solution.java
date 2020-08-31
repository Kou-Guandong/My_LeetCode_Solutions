import java.util.*;

class Solution_503 {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 2, 4, 1, 3, 5, 7, 6 };
        Solution_503 sol = new Solution_503();
        System.out.println(Arrays.toString(sol.nextGreaterElements(A))); // [4,5,3,5,7,-1,7]
    }
}