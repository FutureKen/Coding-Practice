// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//
//
// Return all such possible sentences.
//
//
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
//
//
//
// A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s.length() == 0 || s == null) {
            return res;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (wordDict.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String rPart = s.substring(i);
            if (wordDict.contains(rPart)) {
                List<String> lPart = wordBreak(s.substring(0, i), wordDict);
                for (int j = 0; j < lPart.size(); j++) {
                    res.add(lPart.get(j) + " " + rPart);
                } 
            }
        }
        map.put(s, res);
        return res;
    }
}
