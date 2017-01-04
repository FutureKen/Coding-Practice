// Design and implement a TwoSum class. It should support the following operations: add and find.
//
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
//
//
// For example,
//
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false


public class TwoSum {
    private Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure. O(1) time
    public void add(int number) {
        if (hash.containsKey(number)) {
            hash.put(number, 2);
        } else {
            hash.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value. O(n) time
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int num1 = entry.getKey();
            int num2 = value - num1;
            if ((num1 == num2 && entry.getValue() > 1) || (num1 != num2 && hash.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
