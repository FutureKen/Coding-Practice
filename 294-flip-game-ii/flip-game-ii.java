// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
//
//
// Write a function to determine if the starting player can guarantee a win.
//
//
//
// For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
//
//
// Follow up:
// Derive your algorithm's runtime complexity.


public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return canWinChecker(s, map);
    }
    private boolean canWinChecker(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int i = s.indexOf("++", 0);
        while (i >= 0) {
            String t = s.substring(0, i) + "--" + s.substring(i + 2);
            if (!canWinChecker(t, map)) {
                map.put(s, true);
                return true;
            }
            i = s.indexOf("++", i + 1);
        }
        map.put(s, false);
        return false;
    }
}
