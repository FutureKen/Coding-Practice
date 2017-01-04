// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0 ) return 0;
        if (points.length == 1 || points.length == 2) return points.length;
        HashMap<Double, Integer> map = new HashMap <Double, Integer>();
        double k;
        Point p1, p2;
        int size = points.length;
        int max = 1;
        int tmp = 1;
        for (int i = 0; i < size; i++){
            tmp = 1;
            p1 = points[i];
            map.clear();
            for (int j = 0; j < size; j++){
                p2 = points[j];
                if (i == j) continue;
                if (p1.x == p2.x && p1.y == p2.y){tmp++;}
                else {
                    if (p1.x == p2.x)   k = Double.MAX_VALUE;
                    else k = ((double)p1.y - (double)p2.y)/((double)p1.x - (double)p2.x);
                    if (map.containsKey(k)){
                        map.put(k, map.get(k)+1);
                    }
                    else map.put(k, 1);
                }
            }
            int count = 0;
            for (int counttmp : map.values()){
                if (counttmp > count){count = counttmp;}
            }
            count += tmp;
            if (count > max)
            max = count;
        }
        return max;
    }
}
