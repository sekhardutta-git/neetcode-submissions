class Solution {
    ;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        return Math.max(dfs(nums,0,n-1,dp1),dfs(nums,1,n,dp2));
    }

    private int dfs(int[] nums, int i, int len, int[] dp){
       if(i>=len){
            return 0;
       }
       if(dp[i]!=0){
          return dp[i];
       }

       int rob = nums[i] + dfs(nums,i+2,len,dp);
       int skip = dfs(nums,i+1,len,dp);
       int max = Math.max(rob,skip);
       dp[i]=max;
return max;

    }

}
