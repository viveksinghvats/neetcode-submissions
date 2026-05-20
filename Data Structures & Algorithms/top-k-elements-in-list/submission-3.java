class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int maxFreq = 0;
        for(int i = 0; i < nums.length; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.remove(nums[i]);
            map.put(nums[i],  value + 1);
            maxFreq = Math.max(maxFreq, value + 1);
        }
        // PriorityQueue queue = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        // for(int key: map.keySet()){
        //     queue.add(key);
        //     if(queue.size() > k){
        //         queue.poll();
        //     }
        // }
        // int i = 0;
        // while(queue.size() > 0){
        //     res[i] = (int)queue.poll();
        //     i++;
        // }

        List[] array = new List[maxFreq + 1];
        for(int key: map.keySet()){
            int frq = map.get(key);
            if(array[frq] == null) array[frq] = new ArrayList();
            array[frq].add(key);
        }
        List<Integer> result = new ArrayList();
        while(result.size() < k && maxFreq > 0){
          if(array[maxFreq] != null){
            result.addAll(array[maxFreq]);
          }
          maxFreq--;
        }


        result = result.subList(0, k);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
