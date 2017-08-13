// O(n^2) solution, brute force, find position, then find next greater element from this position
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null) {
            return findNums;
        }
        for (int i = 0; i < findNums.length; i++) {
            int position = findPosition(findNums[i], nums);
            findNums[i] = findNextGreaterElement(position, nums);
        }
        return findNums;
    }
    
    private int findPosition(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private int findNextGreaterElement(int position, int[] nums) {
        for (int i = position + 1; i < nums.length; i++) {
            if (nums[i] > nums[position]) {
                return nums[i];
            }
        }
        return -1;
    }
}


// O(n) solution
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }
}