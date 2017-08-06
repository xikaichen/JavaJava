public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<Integer>(); // set should be inside, otherwise, next for-loop always breaks at the same number
            for (int num : nums) { // differs on the most significant bit then add to set, otherwise a & mask = b & mask;
                set.add(num & mask);
            }
            int temp = max | (1 << i); // temp是可能的最大值，之后一步检测有没有解能达到这个最大值
            for (int num : set) {
                if (set.contains(temp ^ num)) { // check if there is solution
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
// example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
// Since the MSB is 3, I'll start from i = 3 to make it simplify.

// i = 3, set = {1000, 0000}, max = 1000
// i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
// i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
// i = 0, set = {1110, 1011, 0111, 0010}, max = 1100