class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalOutput = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
           List<List<Integer>> result = findOtherTwo(i, i + 1, nums.length - 1, nums, (nums[i] * -1));
           if(result.size() > 0){
            finalOutput.addAll(result);
           }
        }
        return finalOutput;
    }

    List<List<Integer>> findOtherTwo(int mstart, int start, int end, int[] nums, int target){
        List<List<Integer>> finalList = new ArrayList<>();
        while(start < nums.length && start < end){
            if(nums[start] + nums[end] == target){
                List<Integer> result = new ArrayList<>();
                result.add(nums[mstart]);
                result.add(nums[start]);
                result.add(nums[end]);
                finalList.add(result);
                start++;
                end--;
                while(start < nums.length && start < end && nums[start] == nums[start - 1]){
                    start++;
                }
                while(start < nums.length && start < end && nums[end] == nums[end + 1]){
                    end--;
                }
            }else if(nums[start] + nums[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return finalList;
    }
}
