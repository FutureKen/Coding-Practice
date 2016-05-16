public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> h1 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (h1.containsKey(s.charAt(i))) {
                if (h1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (h1.containsValue(t.charAt(i))) {
                    return false;
            }
            h1.put(s.charAt(i), t.charAt(i));        
        }
        return true;
    }
}