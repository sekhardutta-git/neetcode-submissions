class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        return Math.max(dfs(nums,0),dfs(nums,1));
    }

    public int dfs(int[] nums, int i) {
        if(i>=nums.length){
            return 0;
        }
if(dp[i]!=0){
    return dp[i];
}

int a1 = nums[i] + dfs(nums,i+2);
int a2 = nums[i] + dfs(nums,i+3);
int max = Math.max(a1,a2);
dp[i] = max;
return max;
    }

}
