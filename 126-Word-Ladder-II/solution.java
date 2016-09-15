public class Solution {
	
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	
		HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		ArrayList<List<String>> result = new ArrayList<>();
		ArrayList<String> solution = new ArrayList<>();

		wordList.add(endWord);          
   		bfs(beginWord, endWord, wordList, nodeNeighbors, distance);                 
   		dfs(beginWord, endWord, wordList, nodeNeighbors, distance, solution, result);   
   		return result;
        
    }
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
    	for (String str : dict) {
    		nodeNeighbors.put(str, new ArrayList<String>());
    	}

    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(start);
    	distance.put(start, 0);

    	while (!queue.isEmpty()) {
    		int count = queue.size();
    		boolean found = false;
    		for (int i = 0; i < count; i++) {
    			String cur = queue.poll();
    			int curDist = distance.get(cur);
    			ArrayList<String> neighbors = getNeighbors(cur, dict);

    			for (String neighbor : neighbors) {
    				nodeNeighbors.get(cur).add(neighbor);
    				if (!distance.containsKey(neighbor)) {
    					distance.put(neighbor, curDist + 1);
    					if (end.equals(neighbor)) {
    						found = true;
    					} else {
    						queue.offer(neighbor);
    					}
    				}
    			}

    		}

    		if (found) {
    			break;
    		}
    	}
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
    	ArrayList<String> nbs = new ArrayList<>();
    	char chars[] = node.toCharArray();
    	for (char c = 'a'; c <= 'z'; c++) {
    		for (int i = 0; i < chars.length; i++) {
    			char old = chars[i];
    			chars[i] = c;
    			if (dict.contains(String.valueOf(chars))) {
    				nbs.add(String.valueOf(chars));
    			}
    			chars[i] = old;
    		}
    	}
    	return nbs;
    }

    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> result) {
    	solution.add(cur);
    	if (end.equals(cur)) {
    		result.add(new ArrayList<String>(solution));
    	} else {
    		for (String next : nodeNeighbors.get(cur)) {
    			if (distance.get(next) == distance.get(cur) + 1) {
    				dfs(next, end, dict, nodeNeighbors, distance, solution, result);
    			}
    		}
    	}
    	solution.remove(solution.size() - 1);
    }

}