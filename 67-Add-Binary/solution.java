public class Solution {
    public String addBinary(String a, String b) {
        //We consider String a is longer than b, if not, switch them;
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        String result = "";
        while (pb >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
            pa--;
            pb--; 
        }
        //While String a is longer than String b, we should keep adding the rest part of String a to the result;
        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
            pa--;
        }
        //Check if the highest digit has carry;
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }
}