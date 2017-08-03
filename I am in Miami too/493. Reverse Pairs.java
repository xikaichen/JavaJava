// bit里存的数据没有太多的实际意义，想要得到有结果的结果需要用query(index)
// 和sum query不同的是，query是从前朝后统计，更新是从后朝前更新。而sum query则相反

public class Solution {
    private int query(int[] bit, int i) {
        int sum = 0;
        while (i < bit.length) {
            sum += bit[i];
            i += i & -i; // 因为是加法 所以i是越来越大的 从前朝后
        }
        return sum;
    }

    private void update(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i;
        }
    }
    
    public int reversePairs(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        for (int ele : nums) {
            res += query(bit, index(copy, 2L * ele + 1)); // 先查找
            update(bit, index(copy, ele)); // 再把这个element加入 update bit
        }
        
        return res;
    }

    // index函数input是element，输出的是 这个element在copy数组中的第一个 >= element的index
    // [1,3,2,3,1] 排序好是 [1, 1, 2, 3, 3]. input = 1,输出是1.
    private int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) / 2);
            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l + 1;
    }  
}