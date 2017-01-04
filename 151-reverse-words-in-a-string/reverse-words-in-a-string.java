// Given an input string, reverse the string word by word.
//
//
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
//
//
// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.
//
//
// click to show clarification.
//
// Clarification:
//
//
//
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.


public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0 || s == null){
        	return "";
        }
        String[] array1 = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = array1.length - 1; i >= 0; --i) {
        	if(!array1[i].equals("")) {
        		sb.append(array1[i]).append(" ");
        	}
        }
        if (sb.length()==0){
        	return "";
        } else {
        	return sb.substring(0, sb.length()-1);
        }
    }
}
