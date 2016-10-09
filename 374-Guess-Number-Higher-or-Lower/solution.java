/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        int pick = left + (right - left) / 2;

        while (guess(pick) != 0) {
            
            if (guess(pick) == -1) {
                right = pick;
            } else if (guess(pick) == 1) {
                left = pick + 1;
            }
            pick = left + (right - left) / 2;
        }
        return pick;

    }
}