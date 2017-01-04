// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//
// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(m == 0 && n == 0) {
            return;
        }
        if(m == 0) {
            System.arraycopy(B, 0, A, 0, B.length);
            return;
        }
        if(n == 0) {
            return;
        }
        int i, j, k;
        j = m - 1;
        k = n - 1;
        i = m + n - 1;
        while(j >= 0 && k >= 0) {
            if(A[j] >= B[k]) {
                A[i] = A[j];
                j--;
                i--;
            } else {
                A[i] = B[k];
                k--;
                i--;
            }
        }
        while(k >= 0) {
            A[i] = B[k];
            k--;
            i--;
        }
    }
}
