class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> reached = new HashSet<>();
        reached.add(n);
        
        int number = n;
        
        boolean cont = true;
        while (cont){
            if (number == 1) {
                return true;
            }
            
            //Get sum of squed digits
            number = sumSquares(number);
            if (reached.contains(number)){
                //We have a cycle
                return false;
            }
            
            reached.add(number);
        }
        
        return false;
    }
    
    public int sumSquares(int number){
        int sum = 0;
        int digit = 0;
        while(number > 0) {  
            digit = number % 10;
            sum = sum + digit * digit;  
            number = number / 10;  
        }
        return sum;
    }
}
