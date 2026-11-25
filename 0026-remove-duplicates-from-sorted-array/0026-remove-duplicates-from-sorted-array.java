class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int temp[] = new int[hs.size()];
        int i = 0;
        for(int num: hs) {
            temp[i++] = num;
        }
        Arrays.sort(temp);

        for(int j = 0; j < temp.length; j++) {
            nums[j] = temp[j];
        }

        return hs.size();
    }
}