public class Solution {
    LinkedList<String> itn = new LinkedList<>();
    Map<String, PriorityQueue<String>> path = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] single : tickets) {
            path.putIfAbsent(single[0], new PriorityQueue<>());
            path.get(single[0]).add(single[1]);
        }
        dfs("JFK");
        return itn;
    }
    public void dfs(String departure) {
        PriorityQueue<String> arrivals = path.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        itn.addFirst(departure);
    }
}