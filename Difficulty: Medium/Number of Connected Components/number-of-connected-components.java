class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        int count = 0;
        boolean[] vis = new boolean[V];
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                count++;
                bfs(i, adjList, vis);
            }
        }
        return count;
    }
    
    public void bfs(int node, List<List<Integer>> edges, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        
        while(!q.isEmpty()){
            int u = q.poll();
            
            for(int neighbour: edges.get(u)){
                if(!vis[neighbour]){
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }
}