class Solution {
    public int trap(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int n = nums.length - 1;
        leftMax[0] = nums[0];
        rightMax[n] = nums[n];
        for(int i = 1; i < nums.length; i++){
            leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
            rightMax[n - i] = Math.max(nums[n - i], rightMax[n - i + 1]);
        }
        int totalWater = 0;
        for(int i = 1; i < nums.length - 1; i++){
           int height = Math.min(leftMax[i], rightMax[i]);
           totalWater += (height - nums[i]);
        }
        return totalWater;
    }
}
