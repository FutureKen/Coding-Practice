// Given a collection of intervals, merge all overlapping intervals.
//
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size()<2) return intervals;
        Collections.sort(intervals, new IntervalComp());
        
        Interval prev = intervals.get(0);
        
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                Interval merge = new Interval(prev.start,Math.max(curr.end,prev.end));
                prev = merge;
            }
            else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }
    
    public class IntervalComp implements Comparator<Interval>{
        public int compare (Interval a, Interval b){
            return a.start - b.start;
        }
    }
}
