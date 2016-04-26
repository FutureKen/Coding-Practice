public class Solution {
    public String convert(String s, int numRows) {
    	int lng = s.length();
        if (lng <= numRows || numRows == 1) {
        	return s;
        }
        char[] result = new char[lng];
        int step = 2 * (numRows - 1);
        int count = 0;
        for (int i = 0; i < numRows; i++) {
        	int interval = step - 2 * i;
        	for (int j = i; j < lng; j += step) {
        		result[count] = s.charAt(j);
        		count++;

        		if(interval < step && j + interval < lng && interval > 0 && count < lng) {
        			result[count] = s.charAt(j + interval);
        			count++;
        		}
        	}

        }
        return new String(result);
    }
}