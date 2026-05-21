class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(!isAlphaNumeric(s.charAt(start))){
                start++;
                continue;
            }else if(!isAlphaNumeric(s.charAt(end))){
                end--;
                continue;
            }
            else if(!(s.charAt(start) + "").toUpperCase().equals((s.charAt(end) + "").toUpperCase())){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c){
        if((64< c && c < 91) || (96 < c && c < 123) || (47 < c && c < 58)) return true;
        return false;
    }
}
