import java.util.*;

class LT_26 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int s = 0;
        int e = 0;

        while(e<nums.length){
            if(nums[s]==nums[e]){
                e++;
            }
            else{
                nums[count] = nums[e];
                s = e;
                e++;
                count++;
            }
        }

        for(int i=count; i<nums.length; i++){
            nums[i] = 0;
        }

        return count;
    }
}