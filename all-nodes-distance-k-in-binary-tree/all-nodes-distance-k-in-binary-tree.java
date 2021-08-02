/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        KDistanceDown(root, target, K, result);
        return result;
    }
    public int KDistanceDown(TreeNode node, TreeNode target, int k, List<Integer> result){
        if(node==null){
            return -1;
        }
        if(node==target){
            KDistanceDown(node, k, result);
            return 0;
        }
        int leftDistance = KDistanceDown(node.left, target, k, result);
        if(leftDistance!=-1){
            if(leftDistance+1==k){
                result.add(node.val);
            }else{
                KDistanceDown(node.right, k-leftDistance-2, result);
            }
            return 1+leftDistance;
        }
        int rightDistance = KDistanceDown(node.right, target, k, result);
        if(rightDistance!=-1){
            if(rightDistance+1==k){
                result.add(node.val);
            }else{
                KDistanceDown(node.left, k-rightDistance-2, result);
            }
            return 1+rightDistance;
        }
        return -1;
    }
    public void KDistanceDown(TreeNode node, int k, List<Integer> result){
        if(node==null || k<0){
            return;
        }
        if(k==0){
            result.add(node.val);
        }
        KDistanceDown(node.left, k-1, result);
        KDistanceDown(node.right, k-1, result);
    }
}