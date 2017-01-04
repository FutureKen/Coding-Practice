// Validate if a given string is numeric.
//
//
// Some examples:
// "0" => true
// "   0.1  " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
//
//
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
//
//
//
// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.


public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean numAFTERe = true;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numSeen = true;
                numAFTERe = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numAFTERe = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen && numAFTERe;
    }
}
