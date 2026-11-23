class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length==0){
return new int[][]{newInterval};
        }
       List<int[]> finalIntervals = new ArrayList<>();
       int i=0;
       int n = intervals.length;
       while(i<n && newInterval[0]>intervals[i][1]){
      
        finalIntervals.add(intervals[i]);
          i++;
       }

       while(i<n && newInterval[1] >= intervals[i][0]){
        newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
        newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
          i++;
       }

       finalIntervals.add(newInterval);

while(i<n){
        finalIntervals.add(intervals[i]);
          i++;
       }

       return finalIntervals.toArray(new int[0][]);
       
    }
}
