// 这道题也是用backtrack，但是特点是nums是无序的 数字有重复，在同一层中不能出现重复，在不同层中可以重复
// 如[4, 6, 7, 7];
// [4, 7], [4, 7]不允许（两个7不同）但是[7, 7]可以， 这种时候就要在同一层迭代中申明set，而且不使用remove
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        backtrack(res, temp, nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            res.add(new LinkedList(temp));
        }
        Set<Integer> set = new HashSet<Integer>(); // 注意set申明的位置
        for (int i = start; i < nums.length; i++) {
            if (temp.size() > 0 && temp.get(temp.size() - 1) > nums[i]) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]); // 注意set在这里只add 没有remove, 因为set在每一层recursion中都是一个新的
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// 例如[4, 7, 7, 7]
// 4 该层迭代set = {4}, 进入下一层 下一层set = {7},所以这个时候可以保证{4, 7}只出现一次
// 然后回到7 该层迭代set = {4, 7},进入下一层set = {7}, 可以保证{7, 7}, {7, 7, 7}只出现一次
// 然后迭代就结束了 不会再去看之后的7
