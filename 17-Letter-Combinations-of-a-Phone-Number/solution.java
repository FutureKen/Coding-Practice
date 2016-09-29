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