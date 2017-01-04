// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


public class Solution {
    public int climbStairs(int n) {
        int climb[] = new int[n+1];
        climb[0]=1;
        climb[1]=1;
        for (int i=2; i <= n; i++){
            climb[i]=climb[i-2]+climb[i-1];
        }
        return climb[n];
    }
}
