public class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = bits[i/2] + i%2;
        }
        return bits;
    }
}