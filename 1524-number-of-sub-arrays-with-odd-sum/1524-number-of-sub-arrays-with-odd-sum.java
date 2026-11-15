class Solution {
    class Count {
        int odd;
        int even;

        Count(int odd, int even) {
            this.odd = odd;
            this.even = even;
        }
    }
    public int numOfSubarrays(int[] arr) {
        Count prefix[] = new Count[arr.length + 1];

        int sum = 0;
        int ans = 0;
        int MOD = 1000000007;
        prefix[0] = new Count(0, 1);

        for(int i = 1; i <= arr.length; i++) {
            sum += arr[i - 1];
            if(sum % 2 == 0) {
                int oddCount = prefix[i - 1].odd;
                int evenCount = prefix[i - 1].even;
                ans = (ans + oddCount) % MOD;
                prefix[i] = new Count(oddCount, ++evenCount);
            } else {
                int oddCount = prefix[i - 1].odd;
                int evenCount = prefix[i - 1].even;
                ans = (ans + evenCount) % MOD;
                prefix[i] = new Count(++oddCount, evenCount);
            }
        }

        return (int) (ans % MOD);
    }
}