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
        StringBuilder str = new StringBuilder();
        buildString(root, str);
        return str.toString();
    }
    
    public void buildString(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(list);
    }
    
    public TreeNode buildTree(LinkedList<String> list){
        String firstString = list.removeFirst();
        if(firstString.equals("#"))return null;
        TreeNode node = new TreeNode(Integer.parseInt(firstString));
        node.left = buildTree(list);
        node.right = buildTree(list);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));