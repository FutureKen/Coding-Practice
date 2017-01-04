// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
//
// For example,
// Given sorted array nums = [1,1,1,2,2,3],
//
//
// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


public class Solution {
     public int removeDuplicates(int[] A) {
        if(A.length < 3) {
            return A.length;
        }
        int length = 0;
        boolean onedup = false;
        for(int i = 1; i < A.length; i++) { 
            if(A[i] == A[i - 1] && onedup == false){
                length++;
                A[length] = A[i];
                onedup = true;
            }
            if(A[length] != A[i]){
                length++;
                A[length] = A[i];
                onedup = false;
            }
        }
        return length + 1;
    }
}
