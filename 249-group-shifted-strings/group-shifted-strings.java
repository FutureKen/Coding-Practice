// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
// "abc" -> "bcd" -> ... -> "xyz"
//
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
// A solution is:
//
// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]


public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String bit = getBitMap(s);
            if (!map.containsKey(bit)) {
                map.put(bit, new ArrayList<>());
            }
            map.get(bit).add(s);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String getBitMap(String str) {
        int[] arr = new int[str.length()];
        arr[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(0);
            arr[i] = diff < 0 ? diff + 26 : diff;
        }
        return Arrays.toString(arr);
    }
}
