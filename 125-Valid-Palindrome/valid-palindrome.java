// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
//
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.


public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            while (head < s.length() && !(Character.isLetter(s.charAt(head)) || Character.isDigit(s.charAt(head))) ) {
                head++;
            }
            if (head == s.length()) {
                return true;
            }
            while (tail >= 0 && !(Character.isLetter(s.charAt(tail)) || Character.isDigit(s.charAt(tail))) ) {
                tail--;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                break;
            } else {
                head++;
                tail--;
            }
        }
        return tail <= head;
    }
}
