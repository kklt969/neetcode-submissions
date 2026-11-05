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
Approach:
Use BFS with a FIFO queue. Add the root to the queue.

While the queue is not empty:
    1. Get the current queue size, representing the number of nodes at this level.
    2. Process exactly that many nodes using a for loop.
    3. Remove each node from the front of the queue and add its value to the current level list.
    4. Add its non-null left and right children to the queue.
    5. Add the completed level list to the result.

Each outer while-loop iteration processes one level.

Time Complexity: O(n)
Space Complexity: O(n)
*/



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        

       while(!queue.isEmpty())
       {
        int size  = queue.size();
    
        List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size; i++){

                TreeNode current = queue.poll();

                level.add(current.val);

                if(current.left != null){
                queue.offer(current.left);
                 
                }

                if(current.right != null){
                    queue.offer(current.right);
                    
                }


            }
            
            result.add(level);
        
           
        }


        return result;



    }
}
