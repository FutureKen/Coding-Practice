// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.


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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int rooms = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }          
        });

        pq.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            while (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i].end);
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }
}
