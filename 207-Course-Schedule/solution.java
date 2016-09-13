public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            graph.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int from = queue.poll();
            numCourses--;
            for (int to: graph.get(from)) {
                if (--indegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return numCourses == 0;
    }
}