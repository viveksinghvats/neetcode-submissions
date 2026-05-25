class Solution {
    public int maxArea(int[] nums) {
        int left = 0;
        int leftMax = nums[0];
        int right = nums.length - 1;
        int rightMax = nums[nums.length - 1];
        int maxWater = 0;
        while(left < right){
         int totalWater = Math.min(leftMax, rightMax) * (right - left);
         if(leftMax > rightMax){
            right--;
            rightMax = Math.max(rightMax, nums[right]);
         }else{
            left++;
            leftMax = Math.max(leftMax, nums[left]);
         }
         maxWater = Math.max(totalWater, maxWater);
        }

        return maxWater;
    }
}
