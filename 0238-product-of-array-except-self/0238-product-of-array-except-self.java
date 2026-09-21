class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Answer array
        int[] ans = new int[n];

        // Initialize all values with 1 because
        // we will keep multiplying prefix and suffix products
        Arrays.fill(ans, 1);

        // ----------------------------
        // Pass 1: Store Prefix Products
        // ----------------------------

        int curr = 1; // Running product from the left

        for (int i = 0; i < n; i++) {

            // Product of all elements to the left of i
            ans[i] *= curr;

            // Update running prefix product
            curr *= nums[i];
        }

        // ----------------------------
        // Pass 2: Multiply Suffix Products
        // ----------------------------

        curr = 1; // Running product from the right

        for (int i = n - 1; i >= 0; i--) {

            // Multiply with product of all elements to the right of i
            ans[i] *= curr;

            // Update running suffix product
            curr *= nums[i];
        }

        return ans; 
    }
}