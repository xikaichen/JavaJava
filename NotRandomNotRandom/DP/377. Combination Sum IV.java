//seems backtrack can solve this problem, but actually it can't because it will stackoverflow. 
// the question allows element appear infinite times
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums); // remember sort. 
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) { // is nums[j] > i, then nums[j] can't be a possible factor of i so just break.
                    break;
                }
                if (nums[j] == i) {
                    res[i] += 1;
                } else {
                    res[i] += res[i - nums[j]];
                    // 前j + 1个数到i = 前j个数到i 或者 前j个数到i - nums[j]再取第j + 1个数
                }
            }
        }
        return res[target];
    }

}

// 画dp矩阵，会发现无限背包问题和前一个时刻没有一点关系（res[i] += res[i - nums[j]]）所以只需要一维数组就可以了
// 这里的循环顺序不能改变，必须先遍历容量 在遍历物品，因为只有这样
// 对于每一个容量都可以遍历所有的物品
// 这样[1,5] 和 [5,1]才能够算成是两个
// 如果颠倒循环[1, 5]和[5, 1]就成了一种
// 在这道题中[1, ,1, 2]和[1, 2, 1]算两种