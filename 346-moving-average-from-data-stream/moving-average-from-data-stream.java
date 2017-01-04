// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
// For example,
//
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3


public class MovingAverage {

    Queue<Integer> q;
    int s;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        sum = 0;
        s = size;
    }
    
    public double next(int val) {
        sum += val;
        q.offer(val);
        if (q.size() > s) {
            sum -= q.poll();
        }
        return (double)sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
