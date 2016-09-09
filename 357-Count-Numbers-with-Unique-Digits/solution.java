public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            return 0;
        }
        int result = 10;
        int base = 9;
        for (int i = 2; i <= n; i++) {
            base *= (9 - i + 2);
            result += base;
        }
        return result;
    }
}