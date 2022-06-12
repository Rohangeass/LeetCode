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
    class Pair{
        int sum;
        int tilt;
        Pair()
        {
            sum=0;
            tilt=0;
        }
        Pair(int sum,int tilt)
        {
            this.sum=sum;
            this.tilt=tilt;
        }
    }
    public int findTilt(TreeNode root) {
        Pair ans= findTiltHelper(root);
        return ans.tilt;
    }
    public Pair findTiltHelper(TreeNode node)
    {
        if(node==null)
            return new Pair(0,0);
        Pair l=findTiltHelper(node.left);
        Pair r=findTiltHelper(node.right);
        Pair curr =new Pair(l.sum+r.sum+node.val,Math.abs(l.sum-r.sum)+l.tilt+r.tilt);
        return curr;
    }
}