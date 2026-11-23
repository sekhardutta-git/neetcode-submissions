/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty() || intervals.size() ==1){
return true;
        }
        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
Interval l = intervals.get(0);
        for(int i=1; i<intervals.size();i++){
            Interval c = intervals.get(i);
            if(l.end > c.start){
return false;
            }
            l=c;
        }
return true;
    }
}
