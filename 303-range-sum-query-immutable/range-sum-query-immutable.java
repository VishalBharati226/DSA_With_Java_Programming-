class NumArray {
    int[] nums;
    int[] prefSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefSum = new int[nums.length];
        prefSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefSum[i] = nums[i] + prefSum[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefSum[right]-((left-1<0)? 0 : prefSum[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */