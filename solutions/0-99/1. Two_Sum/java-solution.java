import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] { map.get(target - numbers[i]), i };
            }
            map.put(numbers[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = new int[] { 8, 4, 3, 5 };
        int target = 11;
        int[] result = sol.twoSum(numbers, target);
        System.out.println(Arrays.toString(result)); // [1,3]
    }
}
