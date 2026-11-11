class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cB = costBoth;
        long n1 = need1;
        long n2 = need2;
        if(n1 < n2) {
            long way1 = c1 * n1 + n1 * c2;
            long way2 = cB * n1;
            long way3 = c2 * (n2 - n1);
            long way4 = cB * (n2 - n1);
            return Math.min(way1, way2) + Math.min(way3, way4);
        } else if(n2 < n1) {
            long way1 = c1 * n2 + n2 * c2;
            long way2 = cB * n2;
            long way3 = c1 * (n1 - n2);
            long way4 = cB * (n1 - n2);
            return Math.min(way1, way2) + Math.min(way3, way4);
        } else {
            long way1 = c1 * n1 + c2 * n2;
            long way2 = cB * n1;
            return Math.min(way1, way2);
        }
    }
}