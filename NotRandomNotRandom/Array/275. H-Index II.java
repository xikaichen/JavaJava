// 还是O(n) 和274比没有优化，现在考虑使用O(logn)的算法 binary search of course
public class Solution {
    public int hIndex(int[] citations) {
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= count) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
}


// O(logn)
public class Solution {
    public int hIndex(int[] citations) {
        //binary search
        //要找citations[i] >= citations.length - i,而且要是最小的满足这一条件的i，这样hindex才是最大的
        //返回citations.length - index
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0, right = citations.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (citations[left] >= citations.length - left) {
            return citations.length - left;
        } else if (citations[right] >= citations.length - right) {
            return citations.length - right;
        } else {
            return 0;
        }
    }
}