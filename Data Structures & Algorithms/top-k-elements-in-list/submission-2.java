class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.remove(nums[i]);
            map.put(nums[i],  value + 1);
        }
        PriorityQueue queue = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        for(int key: map.keySet()){
            queue.add(key);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(queue.size() > 0){
            res[i] = (int)queue.poll();
            i++;
        }
        return res;
    }
}
