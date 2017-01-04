// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
// Find all strobogrammatic numbers that are of length = n. 
// For example,
// Given n = 2, return ["11","69","88","96"].
//
//
//
//   Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.


public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int m, int n) {
        if (m == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (m == 1) {
            return new ArrayList<String>(Arrays.asList("0","1","8")); //The mid digit;
        }

        List<String> res = new ArrayList<>();
        List<String> inner = helper(m - 2, n);
        for (String s : inner) {
            if (m != n) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }
        return res;
    }
}
