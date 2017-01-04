// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//
// For example,
//
// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        hash.put('A', 0); //00
        hash.put('C', 1); //01
        hash.put('G', 2); //10
        hash.put('T', 3); //11
        Set<Integer> firstappear = new HashSet<>();
        Set<Integer> secondappear = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= hash.get(s.charAt(j));
            }
            if (!firstappear.add(v) && secondappear.add(v)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
