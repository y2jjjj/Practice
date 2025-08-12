class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        // Step 1: Sort the array to make it easier to avoid duplicates 
        // and use the two-pointer technique
        Arrays.sort(nums);
        
        // Step 2: Iterate over each element as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Skip duplicate values for 'i' to avoid repeated triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Go to the next iteration of the loop
            }
            
            // Step 3: Initialize two pointers: 
            // 'l' for the element just after i, and 'r' for the last element
            int l = i + 1;
            int r = nums.length - 1;
            
            // Step 4: Use the two-pointer technique to find pairs that sum to -nums[i]
            while (l < r) {
                int sums = nums[i] + nums[l] + nums[r];
                
                if (sums == 0) {
                    // Found a valid triplet, add it to the result list
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    // Move both pointers inward to look for new pairs
                    l++;
                    r--;
                    
                    // Skip duplicates for 'l' to avoid repeated triplets
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    
                    // Skip duplicates for 'r' to avoid repeated triplets
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
                else if (sums > 0) {
                    // If sum is too large, move 'r' left to reduce it
                    r--;
                }
                else {
                    // If sum is too small, move 'l' right to increase it
                    l++;
                }
            }
        }
        
        // Step 5: Return the list of all unique triplets
        return list;
    }
}
