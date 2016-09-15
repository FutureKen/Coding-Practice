public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginset = new HashSet<String>(), endset = new HashSet<String>(), visited = new HashSet<String>();
        int len = 1;
        int strlen = beginWord.length();
        beginset.add(beginWord);
        endset.add(endWord);
        while (!beginset.isEmpty() && !endset.isEmpty()) {
            if (beginset.size() > endset.size()) {
                Set<String> temp = beginset;
                beginset = endset;
                endset = temp;
            }
            Set<String> cur = new HashSet<>();
            for (String word : beginset) {
                
                char[] chars = word.toCharArray();
                
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newword = String.valueOf(chars);
                        if (endset.contains(newword)) {
                            return len + 1;
                        }
                        if (!visited.contains(newword) && wordList.contains(newword)) {
                            visited.add(newword);
                            cur.add(newword);
                        }
                        chars[i] = origin;
                    }
                }
            }
            beginset = cur;
            len++;
        }   
        return 0;
    }
}