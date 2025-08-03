class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length]; // Array to store the result
        
        Stack<Integer> stk = new Stack<>(); // Stack to store indices of temperatures
        
        for (int i = 0; i < temperatures.length; i++) {
            // While current temperature is greater than the temperature at index on top of the stack
            while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int l = stk.pop(); // Get the index of the previous cooler day
                ans[l] = i - l;    // Calculate the number of days waited
            }
            stk.push(i); // Push current index onto the stack
        }
        
        return ans; // Return the final answer array
    }
}
