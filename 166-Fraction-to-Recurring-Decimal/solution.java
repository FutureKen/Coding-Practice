public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder rst = new StringBuilder();
        rst.append((numerator < 0) == (denominator < 0) || numerator == 0 ? "" : "-");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        rst.append(num / den);
        num %= den;
        if (num % den == 0) {
            return rst.toString();
        }
        rst.append(".");
        HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
        while (num != 0) {
            hash.put(num, rst.length());
            num *= 10;
            rst.append(num / den);
            num %= den;
            Integer index = hash.get(num);
            if (index != null) {
                rst.insert(index,"(");
                rst.append(")");
                break;
            } 
        }
        return rst.toString();
    }
}