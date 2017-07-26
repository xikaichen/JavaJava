//超时算法 O(n ^ 2)
public class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int temp = 0;
            Set<Integer> set = new HashSet<Integer>();
            while (set.add(nums[index])) {
                index = nums[index];
                temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}

//complexity: O(n), space: O(n)
// 用一个visited, 因为nums里每个元素都不一样 所以不可能有nums[i] = nums[j] = k所以不会有两个不同的元素
// 指向同一个点，那么可以把visited过的点标记掉
public class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int index = i;
            int temp = 0;
            Set<Integer> set = new HashSet<Integer>();
            while (set.add(nums[index])) {
                visited[index] = true;
                index = nums[index];
                temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}


// complexity: O(n), space: O(1)
// 因为数字有范围，所以访问过的点标记成Integer.MAX_VALUE就可以了
public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}