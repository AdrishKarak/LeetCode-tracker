class Solution {
    public int findJudge(int n, int[][] trust) {
       // Special case:
        // Single person is automatically the judge
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        // Net trust score for each person
        int[] count = new int[n + 1];

        for (int[] relation : trust) {

            int truster = relation[0];
            int trusted = relation[1];

            // Person trusts someone
            count[truster]--;

            // Person is trusted
            count[trusted]++;
        }

        // Judge must have score n-1
        for (int person = 1; person <= n; person++) {

            if (count[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}