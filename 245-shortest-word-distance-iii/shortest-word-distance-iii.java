// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// word1 and word2 may be the same and they represent two individual words in the list.
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//
// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.
//
//
//
// Note:
// You may assume word1 and word2 are both in the list.


public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words.length==0||words==null){
            return 0;
        }
        int distance = Integer.MAX_VALUE;
        int index1 = words.length-1;
        int index2 = words.length-1;
        int turn=0;
        if(word1.equals(word2)) turn = 1;
        
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1) && (turn==0 || turn==1)){
                index1 = i;
                if(turn == 1) turn = 2;
                distance = Math.min(Math.abs(index1-index2),distance);
            }
            else if(words[i].equals(word2) && (turn==0 || turn==2)){
                index2 = i;
                if(turn == 2) turn = 1;
                distance = Math.min(Math.abs(index1-index2),distance);
            }
        }
        return distance;
    }
}
