class sortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0){
                //swap with left
                //left++, index++; because index should >= left
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == 1) {
                //left,right don't move, index++
                index++;
            } else {
                //swap with right
                //right--; but index doesn't move
                swap(nums, index, right);
                right--;
            }
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}