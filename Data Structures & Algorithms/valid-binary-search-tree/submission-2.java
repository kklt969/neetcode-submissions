/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
Approach: Use DFS with recursion to traverse the tree while maintaining
a valid range (min and max) for each node's value.

If a node's value falls outside its allowed range, return false.

When moving to the left child, update the maximum boundary to the
current node's value. When moving to the right child, update the
minimum boundary to the current node's value.

If all nodes satisfy their valid ranges, return true.





*/


class Solution {
    public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean validate(TreeNode node, long min, long max) {
 
    if(node == null){
        return true;
    }

    if(node.val <= min || node.val >= max){
        return false;
    }


    return validate(node.left,min,node.val) && validate(node.right,node.val,max);

}
    
}


