// 先算preSum超时了 因为这里还有update的过程 所以如果update很多的话 还是很耗时间
public class NumArray {
    public int[] sums;
    public int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums == null) {
            sums = null;
        } else if (nums.length == 0) {
            sums = new int[0];
        } else {
            this.sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }
    
    public void update(int i, int val) {
        int diff = nums[i] - val;
        for (int start = i; start < sums.length; start++) {
            sums[start] -= diff;
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}

//线段树
public class NumArray {
    public class SegmentTree {
        int start;
        int end;
        SegmentTree left;
        SegmentTree right;
        int sum;
        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
    
    private SegmentTree root;
    public NumArray(int[] nums) {
        root = BuildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTree BuildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTree node = new SegmentTree(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = BuildTree(nums, start, mid);
            node.right = BuildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    public void update(SegmentTree root, int i, int val) {
        if (root.end == root.start) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegmentTree root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return sumRange(root.left, i, j);
        } else if (i >= mid + 1) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
        }
    }
}



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */