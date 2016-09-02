public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while (n > 0) {
            fact /= n;
            sb.append(nums.remove(k / fact));
            k %= fact;
            n--;
        }
        return sb.toString();
    }
}