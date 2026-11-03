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
    Conditions : if p and q are the left and right of root. 
                {
                return root}. 

               if(p.val and q.val < root.val){
                    move left; 
                    lCM(root.left);
               
               }
               if(p.val and q.val > root.val)
               {
                    MOVE right;
               }
               if(p.val == root.val || q.val == root.val){
                LCA = root;
               }



 */

class Solution {

    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        } // base case

    

        if (root.left == p && root.right == q) {
            return root;
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if((p.val == root.val || q.val == root.val)){
            return root;
        }

        return root;



    }
}
