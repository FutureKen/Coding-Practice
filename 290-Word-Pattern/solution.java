public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                } 
                map.put(ch, strs[i]);
            }
        }
        return true;
    }
}