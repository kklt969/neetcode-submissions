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

     
        int result =0;

        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root.val, root));

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < queue.size(); i++){

                NodeInfo current = queue.poll();

                if(current.node.val >= current.maxSoFar){
                    current.maxSoFar = Math.max(current.node.val, current.maxSoFar);
                    result++;

                }

                if(current.node.left != null){
                    queue.offer(new NodeInfo(current.maxSoFar,current.node.left));
                }
                if(current.node.right !=null){
                    queue.offer(new NodeInfo(current.maxSoFar,current.node.right));
                }


            }


        }
            return result;

    }


}

class NodeInfo{

    int maxSoFar;
    TreeNode node;

    public NodeInfo(int maxSoFar, TreeNode node){
        this.maxSoFar = maxSoFar;
        this.node = node;
    }



}
