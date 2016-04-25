public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
        	return 0;
        } 
        str = str.trim();
        if (str.length() == 0) {
        	return 0;
        }
        int index = 0;
        int pn = 1;
        if (str.charAt(index) == '+') {
        	index++;
        } else if (str.charAt(index) == '-') {
        	pn = -1;
        	index++;
        }
        long result = 0;
        while (index < str.length()) {
        	if (str.charAt(index) < '0' || str.charAt(index) > '9') {
        		break;
        	}
        	result = result * 10 + (str.charAt(index) - '0');
        	if (result >= Integer.MAX_VALUE) {
        		break;
        	}
        	index++;
        }
        if (result * pn >= Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        if (result * pn <= Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }
        return (int)result * pn;

    }
}