public class Solution {
    public static int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            /** the first step, determine mid's position
            then using mid divide solution space into two part*/
             
            if(A[mid] > A[start]) {
                if(target < A[mid] && target >= A[start]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            if(A[mid] < A[start]) {
                if(target > A[mid] && target < A[start]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        
        if(A[start] == target) {
            return start;
        }else if(A[end] == target) {
            return end;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] A = {0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
        int[] B = {0,1,2,3};
        int targetA = -9;
        int targetB = 2;
        System.out.println(search(A, targetA));  //should print 4
        System.out.println(search(B, targetB));  //should print 2
    }
}