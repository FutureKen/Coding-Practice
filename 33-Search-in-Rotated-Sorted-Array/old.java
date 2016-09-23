public class Solution {
    public int search(int[] A, int target) {
        if(A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == A[mid]) {
                return mid;                
            } 
            if(A[mid] > A[end]) {
                if(target >= A[start] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(target >= A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == A[start]){
            return start;
        }
        if (target == A[end]){
            return end;
        }
        return -1;
    }
}
