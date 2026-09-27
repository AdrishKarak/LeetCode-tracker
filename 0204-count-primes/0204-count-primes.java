class Solution {
    public int countPrimes(int n) {
         // No primes less than 2
        if (n <= 2) return 0;

        // Initially assume every number from 2 to n-1 is prime
        int cnt = n - 2;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        // Check numbers up to sqrt(n)
        for (int i = 2; i * i < n; i++) {

            if (prime[i]) {

                // Mark multiples of i
                for (int j = i * i; j < n; j += i) {

                    if (prime[j]) {
                        prime[j] = false;
                        cnt--;
                    }
                }
            }
        }

        return cnt;
    }
}