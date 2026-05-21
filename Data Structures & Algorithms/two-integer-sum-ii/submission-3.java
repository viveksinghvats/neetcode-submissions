class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int mid = nums.length - 1;
        
        while(start < mid){
            if(nums[start] + nums[mid] == target) {
                return new int[]{start + 1, mid + 1};
            }
            if(nums[start] + nums[mid] < target) start++;
            else mid--;
        }
        int isZero = -1;
        int isTarget = -1;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] == target) isTarget = i + 1;
          if(nums[i] == 0) isZero = i + 1;
        }
        if(isZero < isTarget)
        return new int[]{isZero, isTarget};
        return new int[]{isTarget, isZero};
    }
}
