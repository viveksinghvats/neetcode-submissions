class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for(int i = 0; i < strs.length; i++){
            filterAnagrams(strs[i], map);
        }

        List<List<String>> list = new ArrayList();

        map.forEach((key, value) -> {
            list.add(value);
        });

        return list;
    }

    private void filterAnagrams(String string, Map<String, List<String>> map){
        int[] arr = new int[26];
        for(int i = 0; i < string.length(); i++){
            arr[string.charAt(i) - 97] += 1;
        }
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
         buffer.append(arr[i] + ";");
        }
        List<String> list;
        if(map.containsKey(buffer.toString())){
          list = map.get(buffer.toString());
        }else{
            list = new ArrayList(); 
        }
        list.add(string);
        map.put(buffer.toString(), list);
    }
}
