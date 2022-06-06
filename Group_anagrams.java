#Group anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, String> mapper = new HashMap<>();
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for (String s: strs){
            Map<Character, Integer> counter = new HashMap<>();
            for(int i=0;i<s.length();i++){
                counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1  );
            }
            
            if (mapper.containsKey(counter)){
                anagrams.get(mapper.get(counter)).add(s);
            }else {
                mapper.put(counter, s);
                
                List<String> v = new ArrayList<>();
                v.add(s);
                anagrams.put(s, v);
            }
          
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String k: anagrams.keySet()){
            res.add(anagrams.get(k));
        }
        
        return res;
    }
}
