// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// Example 1:
//
// nums1 = [1, 3]
// nums2 = [2]
//
// The median is 2.0
//
//
//
// Example 2:
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// The median is (2 + 3)/2 = 2.5


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return findkthnumber(nums1, 0, nums2, 0, length / 2 + 1); // for odd number length array
        } else {
            return (findkthnumber(nums1, 0, nums2, 0, length / 2) + findkthnumber(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0; // for even number length array
        }
    }

    public static int findkthnumber(int[] A, int marka, int[] B, int markb, int k) {
        if (marka >= A.length) {
            return B[markb + k - 1];
        } else if (markb >= B.length) {
            return A[marka + k - 1];
        }
        if (k == 1) {
            return Math.min(A[marka], B[markb]);
        }
        //The value on position k/2 in each array, if the position has reached the end of array, set it as max value
        int keya = marka + k / 2 - 1 < A.length ? A[marka + k / 2 - 1] : Integer.MAX_VALUE;
        int keyb = markb + k / 2 - 1 < B.length ? B[markb + k / 2 - 1] : Integer.MAX_VALUE;
        if (keya < keyb) {
            //if the value of A on position k/2-1 is smaller than B, get rid of the start point to (start point + k/2) part of A, then start to find the (k - k/2)th number.
            return findkthnumber(A, marka + k / 2, B, markb, k - k / 2);
        } else {
            return findkthnumber(A, marka, B, markb + k / 2, k - k / 2);
        }
    }
}
