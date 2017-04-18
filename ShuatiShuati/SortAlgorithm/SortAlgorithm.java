//1. Quick Sort

public void quickSort(int[] nums, int start, int end, int k) {
	if (start >= end) {
		return;
	}

	int left = start;
	int right = end;
	int mid = nums[(left + right) / 2];   //key point: number not index;

	while (left <= right) { //key point: <=;
		while (left <= right && nums[left] < mid) {  //key point: small to large don't use =;
			left++;
		}
		while (left <= right && nums[right] > mid) {
			right--;
		}

		while (left <= right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	quickSort(nums, start, right, k); //key point: always from start to right, and left to end; 
	quickSort(nums, left, end, k);

	//key point: for quick select, only need use quick sort for half array.
}

private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}

//2. Merge Sort
public void Sort(int[] nums) {
	int[] temp = new int[nums.length];
	mergeSort(nums, 0, nums.length - 1, temp);
}

private void mergeSort(int[] nums, int start, int end, int[] temp) {
	if (start >= end) {    //key point: remember the exit of mergeSort;
		return;
	}

	int mid = (start + end) / 2;
	mergeSort(nums, 0, mid, temp);
	mergeSort(nums,mid + 1, end, temp);
	merge(nums, start, mid, end, temp);   //key point: give mid to decide the pivot of merge;
}

private void merge(int[] nums, int start, int mid, int end, int[] temp) {
	int left = start;
	int right = mid + 1;
	int index = start;   //index should equals to start instead of 0;

	while (left <= mid && right <= end) {   //key point: <=;
		if (nums[left] < nums[right]) {
			temp[index] = nums[left];
			left++;
		} else {
			temp[index] = nums[right];
			right++;
		}
		index++
	}

	while (left <= mid) {   
		nums[index] = nums[left];
		left++;
		index++;
	}

	while (right <= end) {
		nums[index] = nums[right];
		right++;
		index++;
	}

	for (int i = start i <= end; i++) {   //key point: copy from temp to nums;
		nums[index] = temp[index];
	}
}


























