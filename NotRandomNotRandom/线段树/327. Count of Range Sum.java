// 1. SegmentTreeNode 存什么？
// 存的是rangeSum(0, i)的值的范围[min, max]
// 2. 怎么建SegmentTreeNode?
// 正常建法，valArr是sort了之后的prefixSum。按照这个array来建立线段树
// 3. update方程在干什么? 
// 传入一个值，update方程check这个值属不属于SegmenTreeNode所表示的范围，如果表示这个点的count加一
// 4. getCount函数？
// 传入一个范围，统计count在这个范围内的总和.
// 如果传入的范围包括了node保存的范围，那么node.count整个都是
// 5. ans += getCount(root, (long) lower + sum, (long) upper + sum)什么意思
// 因为是从后朝前遍历
// 等于之前的segmenttree里已经存了rangeSum(0, last), rangSum(0, last - 1),....,rangeSum(0, i + 1)的信息了
// 所以getCount(root, (long) lower + sum, (long) upper + sum) 得到的是rangeSum(i, i + 1),...,ranngeSum(i, last)在不在[low, up]里的数量


// segment tree hard
public class Solution {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;
        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
    private SegmentTreeNode buildSegmentTree(Long[] valArr, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(valArr[start], valArr[end]);
        if (start == end) {
            return node;
        }
        int mid = (start + end) / 2;
        node.left = buildSegmentTree(valArr, start, mid);
        node.right = buildSegmentTree(valArr, mid + 1, end);
        return node;
    }
    private void updateSegmentTree(SegmentTreeNode node, Long val) {
        if(node == null) {
            return;
        }
        if (val >= node.min && val <= node.max) {
            node.count++;
            updateSegmentTree(node.left, val);
            updateSegmentT  ree(node.right, val);
        }
    }
    private int getCount(SegmentTreeNode node, long min, long max) {
        if (node == null) {
            return 0;
        }
        if (min > node.max || max < node.min) {
            return 0;
        }
        if (min <= node.min && max >= node.max) {
            return node.count;
        }
        return getCount(node.left, min, max) + getCount(node.right, min, max);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
            
        }
        return ans;
    }
    
}