/**
 *     Variables and definitions used in the code and its meaning.
 *     int val = value of the node addressed.
 *     TreeNode left = left node/subtree of the tree.
 *     TreeNode right = right node/subtree of the tree.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
