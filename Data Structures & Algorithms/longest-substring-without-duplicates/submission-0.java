class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 1;
        int n = s.length();
        while(end < n && start <= end){
            char c = s.charAt(end);
            if(!map.containsKey(c)){
                map.put(c, 1);
                end++;
                maxLength = Math.max(maxLength, (end - start));
            }else{
                while(map.containsKey(c) && start < end){
                    map.remove(s.charAt(start));
                    start++;
                }
            }
        }
        return maxLength;
        
    }
}
