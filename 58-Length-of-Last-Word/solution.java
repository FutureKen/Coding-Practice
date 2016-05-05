public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean islast = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && islast == true) {
                break;
            } else if (s.charAt(i) == ' ' && islast == false) {

            } else {
                if (islast == true) {
                    count++;
                } else {
                    islast = true;
                    count++;
                }
            }
        }
        return count;
    }
}