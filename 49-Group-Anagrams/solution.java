public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] cha = str.toCharArray();
            Arrays.sort(cha);
            String key = String.valueOf(cha);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}