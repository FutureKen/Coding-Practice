// Given a sorted array of integers, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].


public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start, mid ,end;
        int[] bound = new int[2];
        if (A.length == 0){
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }
        // Left bound
        start = 0;
        end = A.length - 1;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(target == A[mid]) {
                end = mid;
            } else if(target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(target == A[start]) {
            bound[0] = start;
        }
        else if(target == A[end]) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
        }

        // right bound
        start = 0;
        end = A.length - 1;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(target == A[mid]) {
                start = mid;
            } else if(target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(target == A[end]) {
            bound[1] = end;
        }
        else if(target == A[start]) {
            bound[1] = start;
        } else {
            bound[1] = bound[0] = -1;
        }
        return bound;
    }
}
