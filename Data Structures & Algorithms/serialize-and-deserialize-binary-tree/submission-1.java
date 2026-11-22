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

public class Codec {
/*
Approach:

Serialization:
Use BFS with a Queue. Add the root to the queue.
While the queue is not empty, remove the current node.
If it is not null, append its value and enqueue its left and right children.
If it is null, append "N".
Use a delimiter to separate values in the serialized string.

Deserialization:
If the data is "N", return null.
Split the string into tokens using the delimiter.
Construct the root using the first token and add it to the queue.

Iterate through the remaining tokens in pairs:

    The first token represents the current node's left child.

    The second token represents its right child.

    If a token is not "N", construct the corresponding TreeNode and enqueue it.

Continue until all tokens are processed, then return the root.
*/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         
            if (root == null) {
        return "N";
    }

        StringBuffer result = new StringBuffer("");
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();

            if(current != null){
                 result.append(current.val);
                 queue.offer(current.left);
                queue.offer(current.right);
            }else{
                result.append('N');
            }

            if(!queue.isEmpty()){
                result.append(",");
            
        }
        }
       System.out.println(result.toString());

        return result.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("N")){
            return null;
        }

        String[] tokens = data.split(",");

         Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        queue.offer(root);

        for(int i = 1; i < tokens.length; i+= 2){

            TreeNode current = queue.poll();

            if(!tokens[i].equals("N")){
                current.left = new TreeNode(Integer.parseInt(tokens[i]));
                 queue.offer(current.left);
            }
            if(!tokens[i+1].equals("N")){
                current.right = new TreeNode(Integer.parseInt(tokens[i+1]));
                queue.offer(current.right);
            }
        

        }


        return root;
    }
}
