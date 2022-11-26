class Solution:
    
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        rows = len(grid);
        cols = len(grid[0])
        diff = [[0 for _ in range(cols)] for _ in range(rows)]
        
        memoOnes = dict()
        memoZeros = dict()
        
        for i in range(rows):
            if "row"+str(i) not in memoOnes.keys():
                memoOnes["row"+str(i)] = sum(grid[i])
            if "row"+str(i) not in memoZeros.keys():
                memoZeros["row"+str(i)] = cols - memoOnes["row"+str(i)]
            for j in range(cols):
                if "col"+str(j) not in memoOnes.keys():
                    memoOnes["col"+str(j)] = sum(grid[v][j] for v in range(rows))
                if "col"+str(j) not in memoZeros.keys():
                    memoZeros["col"+str(j)] = rows - memoOnes["col"+str(j)]
                
                diff[i][j] = memoOnes["row"+str(i)] + memoOnes["col"+str(j)] \
                - memoZeros["row"+str(i)] - memoZeros["col"+str(j)]
                    
        return diff
