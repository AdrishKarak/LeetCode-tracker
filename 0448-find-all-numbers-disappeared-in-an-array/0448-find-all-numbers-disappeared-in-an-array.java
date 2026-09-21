class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         // Mark numbers that are present
        for (int i = 0; i < nums.length; i++) {

            // Convert value to corresponding index
            int idx = Math.abs(nums[i]) - 1;

            // Mark as visited by making it negative
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();

        // Positive positions indicate missing numbers
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}