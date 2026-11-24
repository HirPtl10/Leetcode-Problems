class Solution {
    public int maxLength(int[] nums) {
        int i = 0;
        int ans = 0;
        while (i < nums.length) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;
            int j = i;
            while (j < nums.length) {
                gcd = gcd((int) gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                prod *= (long) nums[j];

                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
                j++;
            }
            i++;
        }
        return ans;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }
}