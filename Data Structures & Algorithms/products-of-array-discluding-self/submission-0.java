class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];

        int[] result = new int[nums.length];
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                leftProd[i] = leftProd[i - 1] * nums[i];
            }else{
                leftProd[i] = nums[i];
            }

            if(i == 0){
                rightProd[n - i - 1] = nums[n- i -1];
            }else{
                rightProd[n - i - 1] = rightProd[n - i] * nums[n - i - 1];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                result[i] = rightProd[i + 1];
            }else if(i == n - 1){
                result[i] = leftProd[i - 1];
            }else{
                result[i] = leftProd[i - 1] * rightProd[i + 1];
            }
        }

        return result;

    }
}  


///

// [1, 2, 8, 48] = leftProd
// [48,48,24,6] = rightProd

// [48, 24, 12, 8]