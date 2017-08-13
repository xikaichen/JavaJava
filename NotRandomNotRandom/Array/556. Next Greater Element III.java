// 算法
// step1: 从右开始找，找到第一个小于之前一个的数字 534976 找到4，
// step2: 再从右开始找，找比4大的最小的那个数字，因为从右向左是递增的，所以找到的第一个比4大的数字就是了，找到6
// step3: 交换4 和 6的位置，变成 536974
// step4: 对974进行排序，变成536479, 得到结果
public class Solution {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }
        int k = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            return -1;
        }
        int l = k;
        for (int i = l; i < arr.length; i++) {
            if (arr[k] < arr[i]) {
                 l = i;
            }
        }
        int temp = arr[l];
        arr[l] = arr[k];
        arr[k] = temp;
        reverse(arr, k + 1);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res * 10 + arr[i];
            if (res > Integer.MAX_VALUE) {
                return -1;
            }
        }
        return (int) res;
    }
    
    private void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}