public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        while (n > 0 && m > 0) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
            } else {
                nums1[i] = nums1[m - 1];
                m--;
            }
            i--;
        }
        if (m == 0) {
            for (int j = 0; j < n; j++) {
                nums1[j] = nums2[j];
            }
        }
    }
}