// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//
//
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//
//
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//
//
// For the last line of text, it should be left justified and no extra space is inserted between words.
//
//
//
// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.
//
//
//
// Return the formatted lines as:
//
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
//
//
//
//
// Note: Each word is guaranteed not to exceed L in length.
//
//
//
// click to show corner cases.
//
// Corner Cases:
//
//
// A line other than the last line might contain only one word. What should you do in this case?
// In this case, that line should be left-justified.


public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            //If this line contains the last word or only contains 1 word, left justify.
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int average = (maxWidth - count) / diff;
                int rest = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= average + (i - index < rest ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res; 
    }
}
