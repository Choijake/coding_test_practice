class LT_189 {
    public void rotate(int[] nums, int k) {
        int idx = k%nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, idx-1);
        rotate(nums, idx, nums.length-1);
    }

    static void rotate(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}