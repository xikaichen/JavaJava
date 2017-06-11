class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int mid = nums[left + (right - left) / 2];
        while (left <= right) {
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
        // 两种可能left = right, 然后left++, right--中间隔了一个元素
        // left和right相邻, 然后left++， right--还是相邻
        // 所以分隔的两部分是[start, right], [left, end]中间可能还有一个元素，然后看 kth element在那一部分
        if (start + k - 1 <= right) { 
            return quickSelect(nums, start, right, k);
        } else if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};