class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i <= 6; i = i + 3)
            for (int j=0; j <= 6; j = j + 3)
                if (!box_valid(board, i, j)){
                    return false;
                }
        
        return board_valid(board);
    }
    
    public static boolean box_valid(char[][] board, int topI, int topJ){
        Map<Integer, Integer> counter = new HashMap<>();
        System.out.println("Boxer " + topI + " " + topJ);
        
        for (int i = topI; i < topI + 3; i++){
            for (int j = topJ; j < topJ + 3 ; j++){
                if (board[i][j] == '.') continue;
                
                Integer v = board[i][j] - '0';
                
                counter.put(v, counter.getOrDefault(v, 0) + 1  );
                if (counter.get(v) == 2) return false;
            }
        }
        return true;
         
    }
    
    public static boolean board_valid(char[][] board){
        Map<Integer, Set<Integer>> row_mapper = new HashMap();
        Map<Integer, Set<Integer>> col_mapper = new HashMap();
        
        for (int i = 0; i < 9; i++){
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
                             
            row_mapper.put(i, rows);
            col_mapper.put(i, cols);
        }
        
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9 ; j++){
                if (board[i][j] == '.') continue;
   
                Integer v = board[i][j] - '0';
                //If the row contains already the same number
                //return invalid
                if (row_mapper.get(i).contains(v)) {
                    return false;
                } else {
                    row_mapper.get(i).add(v);
                }
                
                if (col_mapper.get(j).contains(v)) {
                    return false;
                } else {
                    col_mapper.get(j).add(v);
                }
            }
        }
        return true;
        
    }
}
