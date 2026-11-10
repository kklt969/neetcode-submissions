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
    public int goodNodes(TreeNode root) {

        int result = 0;

        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root,root.val));

        

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                NodeInfo current = queue.poll();

                if(current.node.val >= current.maxSoFar){
                    result++;
                    current.maxSoFar = Math.max(current.maxSoFar, current.node.val);
                }

                if(current.node.left != null){
                    queue.offer(new NodeInfo(current.node.left, current.maxSoFar));
                }
                if(current.node.right != null){
                    queue.offer(new NodeInfo(current.node.right, current.maxSoFar));
                }


            }

        }
        return result;        
    }
}

class NodeInfo{

     TreeNode node;
    int maxSoFar;

    NodeInfo(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }



}