// A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
// Each LED represents a zero or one, with the least significant bit on the right.
//
// For example, the above binary watch reads "3:25".
//
// Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
//
// Example:
// Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
//
//
// Note:
//
// The order of output does not matter.
// The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
// The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".


public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hour = new int[]{8, 4, 2, 1};
        int[] min = new int[]{32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> h = new ArrayList<>(clockHelper(hour, i, 0, 0, new ArrayList<>()));
            List<Integer> m = new ArrayList<>(clockHelper(min, num - i, 0, 0, new ArrayList<>()));
            for (int hnum : h) {
                if (hnum > 11) {
                    continue;
                }
                for (int mnum : m) {
                    if (mnum > 59) {
                        continue;
                    }
                    res.add(hnum + ":" + (mnum < 10 ? "0" + mnum : mnum));
                }
            }
        }
        return res;
    }

    private List<Integer> clockHelper(int[] time, int count, int index, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return res;
        } else {
            for (int i = index; i < time.length; i++) {
                clockHelper(time, count - 1, i + 1, sum + time[i], res);
            }
        }
        return res;
    }
}
