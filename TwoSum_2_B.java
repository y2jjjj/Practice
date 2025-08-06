class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: left at the start, right at the end of the array
        int right = numbers.length - 1;
        int left = 0;

        // Array to store the result (1-based indices)
        int[] ans = new int[2];

        // Loop through the array to find the two numbers that sum up to the target
        for (int i = 0; i < numbers.length; i++) {
            // If sum is less than target, move left pointer to the right
            if ((numbers[left] + numbers[right]) < target) {
                left++;
            }
            // If sum is greater than target, move right pointer to the left
            else if ((numbers[left] + numbers[right]) > target) {
                right--;
            }
            // If sum matches the target, store the 1-based indices in ans
            else {
                ans[0] = left + 1;
                ans[1] = right + 1;
            }
        }

        // Return the result
        return ans;
    }
}
