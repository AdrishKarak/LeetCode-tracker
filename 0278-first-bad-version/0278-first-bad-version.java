/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Search space: versions 1 to n
        int l = 1;
        int h = n;

        while (l <= h) {

            // Prevent integer overflow
            int mid = l + (h - l) / 2;

            if (isBadVersion(mid)) {

                // First bad version could be mid
                // so search left half
                h = mid - 1;

            } else {

                // mid is good
                // first bad version must be after mid
                l = mid + 1;
            }
        }

        // l points to first bad version
        return l;
    }
}