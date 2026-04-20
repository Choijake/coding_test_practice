import java.util.*;

class LT_136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int s = 0;
        int e = 0;
        int seq = 0;
        int answer = 0;
        while(e<nums.length){
            if(nums[s]==nums[e]){
                e++;
                seq++;
            }
            else{
                if(seq==1){
                    answer = nums[s];
                    break;
                }
                s=e;
                seq=0;
            }
        }

        if(seq==1)answer=nums[s];

        return answer;
    }
}