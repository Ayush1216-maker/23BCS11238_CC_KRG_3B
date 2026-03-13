import java.util.*;

class Solution {

    public int maxSum(List<Integer> nums, int k) {

        long MOD = 1000000007;
        int[] bitCount = new int[32];


        for(int num : nums){
            for(int b = 0; b < 32; b++){
                if((num & (1 << b)) != 0){
                    bitCount[b]++;
                }
            }
        }

        long result = 0;


        for(int i = 0; i < k; i++){

            long current = 0;

            for(int b = 0; b < 32; b++){
                if(bitCount[b] > 0){
                    current |= (1L << b);
                    bitCount[b]--;
                }
            }

            result = (result + (current * current) % MOD) % MOD;
        }

        return (int) result;
    }
}