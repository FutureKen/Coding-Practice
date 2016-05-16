public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> h1 = new HashMap<Character, Character>();
        HashMap<Character, Character> h2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (h1.containsKey(c1)) {
                if (h1.get(c1) != c2) {
                    return false;
                } 
            } else {
                h1.put(c1, c2);
            }
            if (h2.containsKey(c2)) {
                if (h2.get(c2) != c1) {
                    return false;
                } 
            } else {
                h2.put(c2, c1);
            }
        }
        return true;
    }
}