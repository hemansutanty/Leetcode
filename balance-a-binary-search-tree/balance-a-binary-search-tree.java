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
    List<TreeNode> sortedList = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedBST(0, sortedList.size()-1);    
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        sortedList.add(root);
        inorder(root.right);
    }
    public TreeNode sortedBST(int start, int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        TreeNode node = sortedList.get(mid);
        node.left = sortedBST(start, mid-1);
        node.right = sortedBST(mid+1, end);
        return node;
    }
}