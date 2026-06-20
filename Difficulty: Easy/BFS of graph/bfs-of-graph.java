class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                bfsHelper(i, adj, vis, returnList);
            }
            
        }
        
        return returnList;
        
    }
    
    public void bfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> returnList){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        vis[node] = true;
        

        while(!queue.isEmpty()){
            int nNode = queue.poll();
            returnList.add(nNode);
            for(int neighbour: adj.get(nNode)){
                if(!vis[neighbour]){
                    queue.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
}