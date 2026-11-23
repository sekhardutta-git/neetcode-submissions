class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
   
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];
    for(int i = 0;i<m;i++){
       dfs(heights,i,0,pacific);
       dfs(heights,i,n-1,atlantic);
    }
    for(int i = 0;i<n;i++){
       dfs(heights,0,i,pacific);
       dfs(heights,m-1,i,atlantic);
    }

 List<List<Integer>> output = new ArrayList<>();
     for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(pacific[i][j] && atlantic[i][j]){
                output.add(Arrays.asList(i,j));
            }
         }
    }
    return output;
}

    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(int[][] heights, int x, int y,boolean[][] visited){
        if(visited[x][y]){
return ; 
        }
        visited[x][y] = true;

    for(int[] d:directions){
       int x1 = x+d[0];
       int y1 = y+d[1];
       if(x1<0 || y1<0 || x1>=heights.length || y1>=heights[0].length){
continue;
       }
       if(heights[x1][y1] >= heights[x][y]){
           dfs(heights,x1,y1,visited);
       }
    }
    }
}
