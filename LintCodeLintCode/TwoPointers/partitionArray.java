public class partitionArray {
    public int partitionArray(int[] nums, int k) {
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    
	    int left = 0;
	    int right = nums.length - 1;
	    while (left <= right) {
	        while (left <= right && nums[left] < k) {
	            left++;
	        }
	        while (left <= right && nums[right] >= k) {
	            right--;
	        }
	        
	        if (left <= right) {
	            swap(nums, left, right);
	            left++;
	            right--;
	        }
	    }
	    return left;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}