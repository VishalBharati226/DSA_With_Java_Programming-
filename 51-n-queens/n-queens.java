

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // initialize board
        for(int i=0;i<n;i++)
            Arrays.fill(board[i], '.');
        
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];
        
        backtrack(0, n, board, col, diag1, diag2, res);
        return res;
    }
    
    private void backtrack(int row, int n, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> res) {
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
                temp.add(new String(board[i]));
            res.add(temp);
            return;
        }
        
        for(int j=0;j<n;j++){
            if(col[j] || diag1[row+j] || diag2[row-j+n-1])
                continue;
            
            board[row][j] = 'Q';
            col[j] = true;
            diag1[row+j] = true;
            diag2[row-j+n-1] = true;
            
            backtrack(row+1, n, board, col, diag1, diag2, res);
            
            board[row][j] = '.';
            col[j] = false;
            diag1[row+j] = false;
            diag2[row-j+n-1] = false;
        }
    }
}