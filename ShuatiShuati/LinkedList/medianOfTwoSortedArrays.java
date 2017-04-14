public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){		
		//A已经舍弃完了A_start不会大于A.length的
		if (A_start == A.length) {
			return B[B_start + k - 1];
		}
		if (B_start == B.length) {
			return A[A_start + k - 1];
		}
        //k=1，没法取中点了
		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}
		//取A,B中点，如果中点不在A,B里面了
		//A的中点不在A里，舍掉B的k/2，因为即使A全部在B的中点之前
		//那第k个点也应该在B的中点之后。所以B的前k/2不可能包含第k个点
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		//连着中点一起扔的
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}