class Solution {
    public void rotate(int[] nums, int k) {
         // Handle cases where k > array length
        k %= nums.length;

        // Step 1: Reverse entire array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}