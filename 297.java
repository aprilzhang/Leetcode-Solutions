/**
297. Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/
import java.util.Optional;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final LinkedList<Optional<TreeNode>> nodes = new LinkedList<>();
        final StringBuilder builder = new StringBuilder();
        nodes.add(Optional.ofNullable(root));
        while(nodes.size()!=0)
        {
            final Optional<TreeNode> node = nodes.remove();
            if(builder.length()>0)
            {
               builder.append(","); 
            }
            builder.append(node.isPresent()?node.get().val:"null");
            if(node.isPresent())
            {
                nodes.add(Optional.ofNullable(node.get().left));
                nodes.add(Optional.ofNullable(node.get().right));
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
        {
            return null;
        }
        final String[] vals = data.split(",");
        if( data.isEmpty()||vals[0].equals("null"))
        {
            return null;
        }
        final LinkedList<TreeNode> nodes = new LinkedList<>();
        final TreeNode root =new TreeNode(Integer.parseInt(vals[0]));
        nodes.add(root);
        for(int i =1;i<vals.length;i+=2)
        {
            final TreeNode node = nodes.remove();
            if(!vals[i].equals("null"))
            {
             node.left = new TreeNode(Integer.parseInt(vals[i]));
             nodes.add(node.left);
            }
            if(i+1<vals.length&&!vals[i+1].equals("null"))
            {
             node.right = new TreeNode(Integer.parseInt(vals[i+1]));
             nodes.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//Best solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));