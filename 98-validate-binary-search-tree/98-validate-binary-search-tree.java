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
    public class trp{
        boolean isBST;
        long max;
        long min;
        trp(){}
        trp(boolean istBST,long max,long min)
        {
            this.isBST=istBST;
            this.max=max;
            this.min=min;
        }
        
    }
    public trp solve(TreeNode node)
    {
        if(node==null)
        {
            return new trp(true,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        trp ln=solve(node.left);
        trp rn=solve(node.right);
        trp mytriplet=new trp();
        mytriplet.isBST=ln.isBST && rn.isBST && ln.max<node.val && rn.min>node.val;
        mytriplet.max=Math.max(rn.max,node.val);
        mytriplet.min=Math.min(ln.min,node.val);
        return mytriplet;
    }
    public boolean isValidBST(TreeNode root) {
        trp ans =solve(root);
        return ans.isBST;
    }
}