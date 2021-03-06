// Write a function that takes a string as input and returns the string reversed.
//
//
// Example:
// Given s = "hello", return "olleh".


public class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }
}
