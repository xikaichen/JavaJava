public class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        // 找到中位数之后，这是一种插入的方法，可以有很多种方法，但是感觉这样方便，odd从1开始，even如果nums的长度是偶数从倒数第二个开始，要不然就从倒数第一个开始
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > median) {
                tmpArr[odd] = nums[i];
                odd += 2;
                continue;
            }
            if (nums[i] < median){
                tmpArr[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while (odd < nums.length) {
            tmpArr[odd] = median;
            odd += 2;
        }
        while (even >= 0) {
            tmpArr[even] = median;
            even -= 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
        int mid = nums[left + (right - left) / 2];
            while (left <= right && nums[left] > mid) {
                left++;
            }
            while (left <= right && nums[right] < mid) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (right - start >= k - 1) {
            return quickSelect(nums, start, right, k);
        } else if (left - start <= k - 1) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    } 
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}