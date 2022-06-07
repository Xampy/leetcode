class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Store the diff to target and the
        //current element
        Map<Integer, Integer> dt = new HashMap<>();
        
        int[] result = new int[2];
        
        for (int index = 0; index < nums.length; index ++){
            if (dt.containsKey(nums[index]) &&  dt.get(nums[index]) != index){
                result[0] = index;
                result[1] = dt.get(nums[index]);
            }
            dt.put(target - nums[index], index);   
        } 
        return result;
        
    }
}
