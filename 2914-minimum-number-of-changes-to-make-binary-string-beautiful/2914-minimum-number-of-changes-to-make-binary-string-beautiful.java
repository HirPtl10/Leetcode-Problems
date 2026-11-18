class Solution {
    public int minChanges(String s) {
        int i = 1;
        int ans = 0;
        
        while(i < s.length()) {
            if(s.charAt(i - 1) != s.charAt(i)) {
                ans++;
            }

            i = i + 2;
        }

        return ans;
    }
}