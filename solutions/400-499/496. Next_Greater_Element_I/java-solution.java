import java.util.*;

class Solution_496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_496 sol = new Solution_496();
        int[] findNums = new int[] {2,3,4,1};
        int[] nums = new int[] {1,5,3,2,4};
        int[] result = sol.nextGreaterElement(findNums, nums);
        System.out.println(Arrays.toString(result));
    }
}