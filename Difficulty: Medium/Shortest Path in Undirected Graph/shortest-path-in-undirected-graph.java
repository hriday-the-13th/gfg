class Solution {
    public record Pair(int distance, int node){}
        
    public int[] shortestPath(int V, int[][] edges, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        int[] distance = new int[V];
        for(int i=0; i<V; i++){
            distance[i] = (int) 1e9;
        }
        
        pq.add(new Pair(0, src));
        distance[src] = 0;
        
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int dist = pair.distance();
            int node = pair.node();
            
            for(int neighbour: adjList.get(node)){
                if(dist + 1 < distance[neighbour]){
                    distance[neighbour] = dist + 1;
                    pq.add(new Pair(distance[neighbour], neighbour));
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(distance[i] == (int) 1e9){
                distance[i] = -1;
            }
        }
        
        return distance;
    }
    
    // public int[] shortestPath(int V, int[][] edges, int src) {
    //     // code here
    //     Queue<Integer> q = new LinkedList<>();
        
    //     int[] distance = new int[V];
    //     Arrays.fill(distance, Integer.MAX_VALUE);
        
    //     List<List<Integer>> adjList = new ArrayList<>();
        
    //     for(int i=0; i<V; i++){
    //         adjList.add(new ArrayList<>());
    //     }
        
    //     for(int[] edge: edges){
    //         int u = edge[0];
    //         int v = edge[1];
            
    //         adjList.get(u).add(v);
    //         adjList.get(v).add(u);
    //     }
        
        
    //     q.add(src);
    //     distance[src] = 0;
        
    //     bfs(q, adjList, distance);
        
    //     for (int i = 0; i < V; i++) {
    //         if (distance[i] == Integer.MAX_VALUE) {
    //             distance[i] = -1;
    //         }
    //     }
        
    //     return distance;
        
        
    // }
    
    // public void bfs(Queue<Integer> q, List<List<Integer>> adjList, int[] distance){
        
    //     while(!q.isEmpty()){
    //         int node = q.poll();
    //         int dist = distance[node];
            
    //         for(int neighbour: adjList.get(node)){
    //             if(distance[neighbour] == Integer.MAX_VALUE){
    //                 q.add(neighbour);
    //                 distance[neighbour] = dist + 1;
    //             }
    //         }
    //     }
        
    // }
}
