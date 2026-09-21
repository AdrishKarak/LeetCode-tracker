class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int num : nums){
            total += num;
        }


        int ltotal=0;
        for(int i=0; i<nums.length; i++){
            int rtotal = total - ltotal - nums[i];
            if(rtotal == ltotal){
                return i;
            }
            ltotal += nums[i];
        }
        return -1;
    }
}