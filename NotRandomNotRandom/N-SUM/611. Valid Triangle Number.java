// 代码是对的但是超时了
public class Solution {
    private int count;
    public int triangleNumber(int[] nums) {
        List<Integer> temp = new LinkedList<Integer>();
        Arrays.sort(nums);
        backtrack(nums, temp, 0);
        return count;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int start) {
        if (temp.size() == 3 && temp.get(0) + temp.get(1) > temp.get(2)) {
            count++;
            temp = null;
            return;
        } 
        if (temp.size() >= 3) {
            temp = null;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// a more clever way, it is very similar to 3sum closest
public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums); // sort first
        int res = 0 ;
        // 和3sum略有不同的地方是，i 是从2到最后一个，left，right都在i前面 这样做的目的是
        // i看成是斜边，如果left + right > i的话 那么left取left和right之间的数全部都大于i，速度会快很多
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}