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
