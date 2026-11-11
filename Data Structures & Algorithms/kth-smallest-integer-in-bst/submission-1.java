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
Approach: Use DFS with inorder traversal (left → root → right).
Since inorder traversal of a BST visits nodes in ascending order,
a counter tracks the position of each visited node.

When the counter reaches k, store the current node's value
as the kth smallest element.
*/

class Solution {


    int result ;
    int count ;

    public int kthSmallest(TreeNode root, int k){
        count = 0;
        visit(root,k);

       return result;
        
    }

    public void visit(TreeNode root, int k){

        if(root == null){

            return ;

        }
        visit(root.left,k);
        count++;
        if(count == k){
            result = root.val;
        }

        visit(root.right,k);
        


    }
}
