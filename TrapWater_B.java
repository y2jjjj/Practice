class Solution {
    public int trap(int[] height) {
        // lmax & rmax track the highest bars seen from left and right
        int lmax = 0;
        int rmax = 0;
        
        // water stores total trapped rainwater
        int water = 0;
        
        // Two pointers starting from both ends
        int left = 0;
        int right = height.length - 1;
        
        // Process until pointers meet
        while (left < right) {
            // Compare heights at both ends
            if (height[left] < height[right]) {
                // Update lmax or add trapped water based on current left height
                if (lmax <= height[left]) {
                    lmax = height[left]; // New left max found
                } else {
                    water += lmax - height[left]; // Water trapped at this index
                }
                left++; // Move left pointer inward
            } else {
                // Update rmax or add trapped water based on current right height
                if (rmax <= height[right]) {
                    rmax = height[right]; // New right max found
                } else {
                    water += rmax - height[right]; // Water trapped at this index
                }
                right--; // Move right pointer inward
            }
        }
        
        return water; // Total trapped water
    }
}
