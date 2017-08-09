public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a < b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums.length; i++) { // main a max-heap, the heap's size is nums.length
            pq.offer(nums[i]);
        }
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}

//better solution
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        for (int i = 0; i < nums.length; i++) { // pq's size is k, so maintain a min-heap cost less time
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
        
    }
}

// quick selection
// quick selection
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
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
        // while循环结束后right 一定在left左边。
        if (right - start + 1 >= k) { // 从start 到 right有 right - start + 1个数
            return quickSelect(nums, start, right, k);
        } else if (left - start + 1 <= k) { // 如果left到start <= k个数，那么说明start 到 left前一个数字不到k - 1，所以从left 到 end去选
            return quickSelect(nums, left, end, k - (left - start));
        } 
        // right  到 start没有k个数，left到start又比k个数多，那就说明第k个数刚好是right 和 left中间隔了的那个数
        return nums[right + 1]; // 
    } 
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}





