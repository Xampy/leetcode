class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //On each unique element we associate a list of indexes
        //that has the number
        Map<Integer, List<Integer>> mapper = new HashMap<>();
        for (int i=0; i < nums.length; i++){
            if (mapper.containsKey(nums[i])){
                mapper.get(nums[i]).add(i);
                
                for (int p: mapper.get(nums[i])){
                    if ( i - p <= k && p != i) return true;
                }
            } else {
                List<Integer> v = new ArrayList<Integer>();
                v.add(i);
                
                mapper.put(nums[i], v);
            }
        }
        
        /*for (Integer m: mapper.keySet()){
            System.out.println("-" + m);
            for (int p: mapper.get(m)){
                System.out.println(p);
                //if ( i - p <= k && p != i) return true;
            }
        }*/
        return false;
    }
}
