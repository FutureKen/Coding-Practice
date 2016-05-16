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