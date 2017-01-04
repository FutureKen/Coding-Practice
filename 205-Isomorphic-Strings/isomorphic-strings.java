// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
// For example,
// Given "egg", "add", return true.
//
// Given "foo", "bar", return false.
//
// Given "paper", "title", return true.
//
// Note:
// You may assume both s and t have the same length.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> h1 = new HashMap<Character, Character>();
        HashSet<Character> mapped = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (h1.containsKey(s.charAt(i))) {
                if (h1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                } else {
                    continue;
                }
            } else if (mapped.contains(t.charAt(i))) {
                    return false;
            }
            h1.put(s.charAt(i), t.charAt(i));
            mapped.add(t.charAt(i));        
        }
        return true;
    }
}
