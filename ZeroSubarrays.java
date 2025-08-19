class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int c=0;long r=0;
        for(int num:nums){
            if(num==0){
                c+=1;
                r+=c;
            }
            else{
                c=0;
            }
        }
        return r;
    }
}
