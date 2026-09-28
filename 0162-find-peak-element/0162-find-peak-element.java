class Solution {
    public int findPeakElement(int[] nums) {
        //Initialize the Search Range
        int left = 0;
        int right = nums.length - 1;

       //Perform Binary Search Until the Search Range Collapses
        while (left < right) {
            int mid = (left + right) / 2;
            //Compare the Midpoint with its Right Neighbor
            //If nums[mid] is greater, it indicates that a peak element might be to the left side, including the mid index itself.
            // Move the Left Pointer Otherwise
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
            //When the while loop ends, left and right will point to the same index, which is a peak element.

        return left;        
    }
}