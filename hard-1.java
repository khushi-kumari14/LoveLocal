/*
Logic of the code - 
    -> Firstly I initialize the array in which n is the length of the array nums, r is the result array to store max values 
       of the sliding window, ri is an index to keep track of the result array and q is the dequeue to keep track of
       indices.
    -> Looping through each element in the array.
    -> Then we remove the indices that are out of the window and whose corresponding values are less than the current value.
    -> If the root value is smaller than both the nodes then the function is called as right subtree as the input.
    -> Then we maintain the result array if the current index i is greater than or equal to the window size k, 
        which means we have a complete window then we add the maximum value in the current window to the result array r, 
	and increment the result index ri.
    -> I added the main function to test the code on different types of test cases.
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
	if (nums == null || k <= 0) {
		return new int[0];
	 }
      int n = nums.length;
      int[] r = new int[n-k+1];
      int ri = 0;
      Deque<Integer> q = new ArrayDeque<>();
      for (int i = 0; i < nums.length; i++) {
        while (!q.isEmpty() && q.peek() < i - k + 1) {
          q.poll();
        }
        while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
          q.pollLast();
        }
        q.offer(i);
        if (i >= k - 1) {
          r[ri++] = nums[q.peek()];
        }
      }
      return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
	int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("Test Case 1: " + Arrays.toString(result1));

        // Test case 2
	int[] nums2 = {1, -1};
        int k2 = 1;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println("Test Case 2: " + Arrays.toString(result2));

        // Test case 3
        int[] nums3 = {9, 11};
        int k3 = 2;
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.println("Test Case 3: " + Arrays.toString(result3));

    }
}
