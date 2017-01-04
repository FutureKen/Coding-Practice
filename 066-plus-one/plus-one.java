// Given a non-negative number represented as an array of digits, plus one to the number.
//
// The digits are stored such that the most significant digit is at the head of the list.


public class Solution {
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for (int i = digits.length-1; carries > 0 && i >= 0; i--) {
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if (carries == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int j = 1; j < result.length; j++) {
                result[j] = 0;
            }
            return result;
        }
    }
}
