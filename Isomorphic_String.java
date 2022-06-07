class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapper = new HashMap<>();
        
        for (int i=0; i < s.length(); i++){
            if (mapper.containsKey(s.charAt(i))){
                if (t.charAt(i) != mapper.get(s.charAt(i))){
                    return false;
                }
            }else {
                if (mapper.containsValue(t.charAt(i))) {
                    return false;
                }
                mapper.put(s.charAt(i), t.charAt(i));
            }
        }
        
        return true;
    }
}
