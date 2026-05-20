class Solution {

    public String encode(List<String> strs) {
     StringBuffer buffer = new StringBuffer();

     for(String entry : strs){
        buffer.append(entry.length());
        buffer.append("#");
        buffer.append(entry);
     }
     return buffer.toString();
    }

    public List<String> decode(String str) {
      List<String> result = new ArrayList();
      int last = -1;
      for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == '#'){
            int length = Integer.parseInt(str.substring(last + 1, i));
            String word = str.substring(i + 1, i + 1 + length);
            result.add(word);
            i = i + length;
            last = i;
        }
      }
      return result;
    }
}
