class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.remove(nums[i]);
            map.put(nums[i],  value + 1);
        }
        int[] res = new int[k];
        AtomicInteger j = new AtomicInteger(0);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> {
            int idx = j.getAndIncrement();
            if(idx < k){
                res[idx] = e.getKey();
            }
        });
        
        return res;
    }
}
