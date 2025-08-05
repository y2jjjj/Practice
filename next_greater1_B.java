class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Stack to maintain a decreasing sequence
        Stack<Integer> stk = new Stack<>();

        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> map = new HashMap<>();

        // Result array to store answers for each element in nums1
        int[] ans = new int[nums1.length];

        // Step 1: Traverse nums2 to build the next greater map
        for (int i = 0; i < nums2.length; i++) {
            // While the current number is greater than stack's top,
            // it is the next greater for the top element
            while (!stk.isEmpty() && nums2[i] > stk.peek()) {
                map.put(stk.pop(), nums2[i]);
            }

            // Push the current number to stack for future comparison
            stk.push(nums2[i]);
        }

        // Step 2: For all elements left in the stack, no next greater exists
        while (!stk.isEmpty()) {
            map.put(stk.pop(), -1);
        }

        // Step 3: Build the result for nums1 using the map
        for (int j = 0; j < nums1.length; j++) {
            ans[j] = map.get(nums1[j]);  // Guaranteed to be present since nums1 ⊆ nums2
        }

        // Return the final result
        return ans;
    }
}
