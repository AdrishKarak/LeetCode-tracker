class Solution {
    public void moveZeroes(int[] nums) {
        //initialize a variable left to keep track of the position where the next non-zero element will be moved
        int left =0;

        for(int right=0; right<nums.length; right++){
            if(nums[right] != 0){
                int temp = nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
            }
        }
    }
}