public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>(); 
        helper(res, s, "", 0);
        return res;
    }
    private void helper(List<String> res, String s, String tmp, int parts) {
        if (parts == 4) {
            if (s.length() == 0) {
                //Prevent adding the last '.';
                res.add(tmp.substring(0, tmp.length() - 1));
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (s.length() < i){
                break;
            }
            int ip = Integer.parseInt(s.substring(0, i));
            //Check if ip segment is valid. 010 will be parsed as 10, so it is not valid.
            if (ip > 255 || i != String.valueOf(ip).length()) {
                continue;
            }
            helper(res, s.substring(i), tmp + s.substring(0, i) + '.', parts + 1);
        }
    }
}
