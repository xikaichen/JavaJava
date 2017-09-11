public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1, 0, 2);
    }
    
    private void sort(int[] nums, int left, int right, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        int l = left, r = right;
        int midColor = (colorFrom + colorTo) / 2;
        while (l < r) {
            while (l < r && nums[l] <= midColor) {
                l++;
            }
            while (l < r && nums[r] > midColor) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        sort(nums, left, r, colorFrom, midColor);
        sort(nums, l, right, midColor + 1, colorTo);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}



// 其实就是一个标准的quick sort
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    
    public void quickSort(int[] nums, int start, int end)
        {  
          if(start >= end) {
             return;
          }

          int left = start;
          int right = end;
          int mid = nums[left + (right - left) / 2];  

          while(left <= right)
          {  // Increment left pointer until left >= pivot
             while (left <= right && nums[left] < mid) // 不能用=因为，left可能移动到了end, while循环终止，又重新sort start 到 end 无尽循环
                left++;

             // Increment right pointer until right <= pivot
             while (left <= right && nums[right] > mid)
                right--;

             // If left < right; swap values
             if (left <= right)
             {  swap(nums, left, right);
                left++;
                right--;
             }

          }
          quickSort(nums, start, right);
          quickSort(nums, left, end);
          // 不能用quickSort(nums, start, left);
          //quickSort(nums, right, end); 无法handle [0, 0]这种case，因为left移动到了end的位置，循环永远不会停止
        }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}