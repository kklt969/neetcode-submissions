class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary search the shorter array to achieve O(log(min(m, n)))
        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            A = nums2;
            B = nums1;
        }

        int m = A.length;
        int n = B.length;

        int left = 0;
        int right = m;

        // Number of elements that should be on the left side.
        // +1 ensures the left side has one extra element when total is odd.
        int half = (m + n + 1) / 2;

        while (left <= right) {

            // i = number of elements taken from A for the left partition
            int i = left + (right - left) / 2;

            // j = number of elements needed from B to complete the left partition
            int j = half - i;

            // Values immediately before and after each cut.
            // MIN_VALUE / MAX_VALUE handle cuts at array boundaries.
            int leftA = (i == 0)
                    ? Integer.MIN_VALUE : A[i - 1];

            int rightA = (i == m)
                    ? Integer.MAX_VALUE : A[i];

            int leftB = (j == 0)
                    ? Integer.MIN_VALUE : B[j - 1];

            int rightB = (j == n)
                    ? Integer.MAX_VALUE : B[j];

            // Valid partition: everything on the left <= everything on the right
            if (leftA <= rightB && leftB <= rightA) {

                // Odd total: the left partition has one extra element
                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                // Even total: average the largest left and smallest right values
                return ((double) Math.max(leftA, leftB)
                        + Math.min(rightA, rightB)) / 2.0;
            }

            // A's left boundary is too large; move the cut in A left
            else if (leftA > rightB) {
                right = i - 1;
            }

            // B's left boundary is too large; move the cut in A right
            else {
                left = i + 1;
            }
        }

        // The input arrays are sorted, so a valid partition will be found.
        return 0.0;
    }
}