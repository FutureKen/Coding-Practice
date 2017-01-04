// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
//
// Here are few examples.
// [1,3,5,6], 5 &#8594; 2
// [1,3,5,6], 2 &#8594; 1
// [1,3,5,6], 7 &#8594; 4
// [1,3,5,6], 0 &#8594; 0


public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A.length == 0) {
            return 0;
        }
        if(target > A[A.length - 1]) {
            return A.length;
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target == A[mid]) {
                return mid;
            } else if(target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if(target <= A[start]) {
            return start;
        }
        if(target == A[end]) {
            return end;
        }
        return start + 1;
    }
}
