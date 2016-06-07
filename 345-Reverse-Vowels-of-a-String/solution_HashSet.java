public class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(str[i])) {
                i++;
            }
            while (i < j && !vowels.contains(str[j])) {
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