public class Solution {
    static final String vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();     
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            while (i < j && vowels.indexOf(str[i]) == -1) {
                i++;
            }
            while (i < j && vowels.indexOf(str[j]) == -1) {
                j--;
            }
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }
}