/**
 *     Variables and definitions used in the code and its meaning.
 *     int val = value of the node addressed.
 *     TreeNode left = left node/subtree of the tree.
 *     TreeNode right = right node/subtree of the tree.
    Logic of the code - 
    -> Firstly the code takes an input from the root of the tree which is an array of the nodes of the tree and the 2 nodes.
    -> The two nodes given as arguments are the two nodes whose LCA we need to find.
    -> If the root value is bigger than both the nodes then the function is called as the left subtree as the input.
    -> If the root value is smaller than both the nodes then the function is called as right subtree as the input.
    -> The solution is the Divide and Conquer type of technique.
    -> I added the main function to test the code on different types of test cases.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);

        TreeNode p1 = root1.left;  
        TreeNode q1 = root1.right; 

        TreeNode result1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("LCA Test 1: " + result1.val);

}
