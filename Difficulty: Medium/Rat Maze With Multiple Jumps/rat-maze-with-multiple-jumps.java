class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        // code here
        int n = mat.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] vis = new int[n][n];
        for(int[] row: vis){
            Arrays.fill(row, -1);
        }
        int[][] path = new int[n][n];
        if(rec(mat, path, 0, 0, n, vis) != 1){
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            sublist.add(-1);
            list.add(sublist);
            return list;
        }
        
        for(int i = 0; i<n; i++){
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int j=0; j<n; j++){
                sublist.add(path[i][j]);
            }
            list.add(sublist);
        }
        
        return list;
        
    }
    
    public int rec(int[][] mat, int[][] path, int row, int col, int n, int[][] vis){
        if(row == n-1 && col == n-1){
            // vis[row][col] = 1;
            path[row][col] = 1;
            return 1;
        }
        
        if(mat[row][col] == 0){
            return 0;
        }
        
        if(vis[row][col] != -1){
            return vis[row][col];
        }
        
        if(row>=0 && row<n && col>=0 && col<n && mat[row][col] != 0 && path[row][col] == 0){
            
            
            
            path[row][col] = 1;
            
            
            for(int i=1; i <= mat[row][col] && i < n; i++){
                
                if(col + i < n && rec(mat, path, row, col + i, n, vis) == 1){
                    vis[row][col] = 1;
                    return vis[row][col];
                }
                
                
                if(row + i < n && rec(mat, path, row + i, col, n, vis) == 1){
                    vis[row][col] = 1;
                    return vis[row][col];
                }
            }
            
            
            path[row][col] = 0;
            
            vis[row][col] = 0;
            
            return vis[row][col];
        }
        
        vis[row][col] = 0;
        return vis[row][col];
    }
}