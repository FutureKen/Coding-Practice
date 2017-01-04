// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
//
//
//
// Example:
// Given binary tree 
//
//           1
//          / \
//         2   3
//        / \     
//       4   5    
//
//
//
// Returns [4, 5, 3], [2], [1].
//
//
//
// Explanation:
//
// 1. Removing the leaves [4, 5, 3] would result in this tree:
//
//           1
//          / 
//         2          
//
//
//
// 2. Now removing the leaf [2] would result in this tree:
//
//           1          
//
//
//
// 3. Now removing the leaf [1] would result in the empty tree:
//
//           []         
//
//
//
//
// Returns [4, 5, 3], [2], [1].
//
//
// Credits:Special thanks to @elmirap for adding this problem and creating all test cases.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        findLeavesHelper(result,root);
        return result;
    }
    
    public int findLeavesHelper(List<List<Integer>> result, TreeNode node){
	
    	//from bottom up
    	if(node==null){
    		return -1;
    	}
    	int left = findLeavesHelper(result,node.left);
    	int right = findLeavesHelper(result,node.right);
    	int curr = Math.max(left, right) + 1;
    	
    	if(result.size()<=curr){
    		result.add(new ArrayList<Integer>());
    	}
    	result.get(curr).add(node.val);
    	return curr;
    }
}
