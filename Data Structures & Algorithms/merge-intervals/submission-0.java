class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] a : intervals){
             if(result.isEmpty() || result.get(result.size()-1)[1]<a[0]){
result.add(a);
             }else{
               int[] l =  result.get(result.size()-1);
               l[1] = Math.max(a[1],l[1]);
             }
        }

       return result.toArray(new int[result.size()][]);
    }
}
