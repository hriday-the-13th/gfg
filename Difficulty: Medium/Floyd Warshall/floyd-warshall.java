class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        
        
        for(int via=0; via<dist.length; via++){
            for(int i=0; i<dist.length; i++){
                for(int j=0; j<dist.length; j++){
                    if(dist[i][via] != (int) 1e8 && dist[via][j] != (int) 1e8){
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }
}