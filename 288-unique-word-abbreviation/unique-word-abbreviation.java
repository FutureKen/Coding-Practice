// An abbreviation of a word follows the form &lt;first letter&gt;&lt;number&gt;&lt;last letter&gt;. Below are some examples of word abbreviations:
//
// a) it                      --> it    (no abbreviation)
//
//      1
// b) d|o|g                   --> d1g
//
//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n
//
//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
//
//
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
// Example: 
//
// Given dictionary = [ "deer", "door", "cake", "card" ]
//
// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true


public class ValidWordAbbr {

    HashMap<String, String> abbr = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String ab = s.length() < 3 ? s : s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
            if (abbr.containsKey(ab)) {
                if (!abbr.get(ab).equals(s)){
                    abbr.put(ab, "");
                }
            } else {
                abbr.put(ab, s);
            }

        }
    }

    public boolean isUnique(String word) {
        String ab = word.length() < 3 ? word : word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        return !abbr.containsKey(ab) || abbr.get(ab).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
