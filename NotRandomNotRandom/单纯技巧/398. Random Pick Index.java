// 水塘抽样（RESERVOIR SAMPLING）：可否在一未知大小的集合中，随机取出一元素？每个元素取到的概率相等

// 1. nextInt(n), 生产从0 到 n - 1的随机整数
// 2. n = 1表示target没有重复 这个时候 x 必等于 0， res = i
// 3. n > 1之后，例如n = 2， 一开始res = 1st index，然后有1 ／ 2的概率保存这个index，也有1 ／ 2的概率换成2nd index
// n = 3， 有2 ／ 3的概率保存之前的index， 1 ／ 3的概率换成新的index
// 4. 由条件概率可以算出 每个坐标出现的概率是1 / n
public class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                total++;
                int x = rand.nextInt(total); 
                System.out.println(rand.nextInt(1));
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */