class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n];
return climb(n);
    }

     public int climb(int n) {
    
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;   
        }
        if(dp[n-1]!=0){
          return dp[n-1];
        }

  int c = climb(n-1)+climb(n-2);
    dp[n-1]=c;
return c;
    }

}
