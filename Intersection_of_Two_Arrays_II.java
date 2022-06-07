class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count_one = new HashMap<>();
        Map<Integer, Integer> count_two = new HashMap<>();
        
        for (int i=0; i < nums1.length; i++){
            count_one.put(nums1[i], count_one.getOrDefault(nums1[i], 0) + 1  );
        }
        
        for (int i=0; i < nums2.length; i++){
            count_two.put(nums2[i], count_two.getOrDefault(nums2[i], 0) + 1  );
        }
        
        //Make the intersection
        List<Integer> result = new ArrayList<Integer>();
        for(int number: count_one.keySet()){
            if (count_two.containsKey(number)){
                for (int i=0; i < Math.min(count_one.get(number), count_two.get(number)); i++) {
                    result.add(number);
                } 
            }
        }
        
        int[] r = new int[result.size()];
        for (int i=0; i < r.length; i++) r[i] = result.get(i);
        return r;
    }
}
