class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int removed=0;
        int[] last = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] c = intervals[i];
            if(last[1]>c[0]){
                removed++;
                if(c[1]<last[1]){
                    last = c; 
                }
            }else{ 
                 last = c;     
            }
        
        }
        return removed;
    }
}
