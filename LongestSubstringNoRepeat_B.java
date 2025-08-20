class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window with two pointers and a Set
        Set<Character> set = new HashSet<>();
        int l = 0, res = 0;
        
        for (int r = 0; r < s.length(); r++) {
            // If duplicate found, shrink from left
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}
