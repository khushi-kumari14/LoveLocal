/**
 *     Variables and definitions used in the code and its meaning.
 *     int val = value of the node addressed.
 *     TreeNode left = left node/subtree of the tree.
 *     TreeNode right = right node/subtree of the tree.
    Logic of the code - 
    -> Firstly I've handled the base case which is if the array provided is empty the code will return null.
    -> Then I created a helper function which takes 3 arguments - array, the first element (smallest), and the last element (largest).
    -> The helper function finds the middle element and creates a new node out of it.
    -> Then the helper function recursively calls the function taking the first half of the array as one and the second half as one.
    -> The solution is the Divide and Conquer type of technique.
    -> I added the main function to test the code on different types of test cases.
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }
    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] testCase1 = {};
        TreeNode result1 = solution.sortedArrayToBST(testCase1);
        System.out.println("Test Case 1 Result: " + result1);

        
        int[] testCase2 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode result2 = solution.sortedArrayToBST(testCase2);
        System.out.println("Test Case 2 Result: " + result2);

        int testCase3 = {-10,-3,0,5,9};
        TreeNode result3 = solution.sortedArraytoBST(testCase3);
        System.out.println("Test Case 3 result: " + result3);
    }
}
