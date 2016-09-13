public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int[] pair : prerequisites) {
            indegree[pair[1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            res[numCourses] = course;
            for (int[] pair: prerequisites) {
                if (pair[0] == course) {
                    if (--indegree[pair[1]] == 0) {
                        queue.offer(pair[1]);
                    }
                }
            }
        }
        return numCourses == 0 ? res : new int[0];
    }
}