// Given a digit string, return all possible letter combinations that the number could represent.
//
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
//
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.


public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits.length() == 0 || digits.contains("0") || digits.contains("1")) {
            return result;
        }
        result.add("");
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (result.peek().length() == i) {
                String last = result.poll();
                for(char cur : mapping[num].toCharArray())
                result.add(last + cur);
            }
        }
        return result;
    }
}
