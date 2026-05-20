class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        List<Integer> set = new ArrayList<>(map.keySet());
        int maxLength = 0;
        Map<Integer, Integer> keyValueMap = new HashMap<>();
        for(int key: set){
          int length = 1;
          int iKey = key;
          while(true){
            if(map.get(key + 1) != null){
                map.remove(key + 1);
                key++;
                length++;
                maxLength = Math.max(length, maxLength);
            }else if(keyValueMap.get(key + 1) != null){
                length += keyValueMap.get(key + 1);
                key += keyValueMap.get(key + 1);
                maxLength = Math.max(length, maxLength);
            }else{
                keyValueMap.put(iKey, length);
                map.remove(iKey);
                maxLength = Math.max(length, maxLength);
                break;
            }
          }
        }
        return maxLength;
    }
}
