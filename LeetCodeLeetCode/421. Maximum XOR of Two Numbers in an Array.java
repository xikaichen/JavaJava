public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<Integer>(); // set should be inside, otherwise, next for-loop always breaks at the same number
            for (int num : nums) { // find from the most significant bit position to see if there is solution
                set.add(num & mask);
            }
            int temp = max | (1 << i);
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