class Solution {
    int result ;
    public int coinChange(int[] coins, int amount) {
         result = Integer.MAX_VALUE;
           dfs(coins,0,amount,0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(int[] coins,int i,int amount,int coin){
 if(amount == 0){
        result = Math.min(result,coin);
        return;
    }
        if(i>=coins.length || amount < 0 || coin>result){
return;
        }
   

dfs(coins,i,amount-coins[i],coin+1);// include current
dfs(coins,i+1,amount,coin);// exclude current

    }
}
