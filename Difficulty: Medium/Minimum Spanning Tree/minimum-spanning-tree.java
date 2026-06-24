class Solution {
    public record Pair(int cost, int node){}
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[V];
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adjList.get(u).add(new Pair(w, v));
            adjList.get(v).add(new Pair(w, u));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(x.cost, y.cost));
        pq.add(new Pair(0, 0));
        
        
        int minSum = 0;
        
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int cost = pair.cost();
            int node = pair.node();
            
            if(vis[node]) continue;
            
            vis[node] = true;
            minSum += cost;
            
            
            for(Pair neighbour: adjList.get(node)){
                int nCost = neighbour.cost();
                int nNode = neighbour.node();
                if(!vis[nNode]){
                    pq.add(new Pair(nCost, nNode));   
                }
            }
            
        }
        
        return minSum;
    }
}
