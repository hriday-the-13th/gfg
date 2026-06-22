class Solution {
    public record Pair(int distance, int node){}
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        TreeSet<Pair> set = new TreeSet<Pair>((x, y) ->{
            if(x.distance != y.distance) return Integer.compare(x.distance, y.distance);
            return Integer.compare(x.node, y.node);
        });
        // PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        List<List<Pair>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adjList.get(u).add(new Pair(w, v));
            adjList.get(v).add(new Pair(w, u));
        }
        
        set.add(new Pair(0, src));
        // pq.add(new Pair(0, src));
        
        int[] distance = new int[V];
        
        for(int i=0; i<V; i++){
            distance[i] = (int) 1e9;
        }
        
        distance[src] = 0;
        
        while(!set.isEmpty()){
            Pair pair = set.pollFirst();
            int node = pair.node();
            int dist = pair.distance();
            
            for(Pair neighbour: adjList.get(node)){
                int w = neighbour.distance();
                int nNode = neighbour.node();
                if(dist + w < distance[nNode]){
                    
                    if (distance[nNode] != (int) 1e9) {
                        set.remove(new Pair(distance[nNode], nNode));
                    }
                    
                    
                    distance[nNode] = dist + w;
                    set.add(new Pair(distance[nNode], nNode));
                }
            }
        }
        
        return distance;
        
    }
    // public int[] dijkstra(int V, int[][] edges, int src) {
    //     // code here
    //     PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
    //     List<List<Pair>> adjList = new ArrayList<>();
        
    //     for(int i=0; i<V; i++){
    //         adjList.add(new ArrayList<>());
    //     }
        
    //     for(int[] edge: edges){
    //         int u = edge[0];
    //         int v = edge[1];
    //         int w = edge[2];
            
    //         adjList.get(u).add(new Pair(w, v));
    //         adjList.get(v).add(new Pair(w, u));
    //     }
        
    //     pq.add(new Pair(0, src));
        
    //     int[] distance = new int[V];
        
    //     for(int i=0; i<V; i++){
    //         distance[i] = (int) 1e9;
    //     }
        
    //     distance[src] = 0;
        
    //     while(!pq.isEmpty()){
    //         Pair pair = pq.poll();
    //         int node = pair.node();
    //         int dist = pair.distance();
            
    //         for(Pair neighbour: adjList.get(node)){
    //             int w = neighbour.distance();
    //             int nNode = neighbour.node();
    //             if(dist + w < distance[nNode]){
    //                 distance[nNode] = dist + w;
    //                 pq.add(new Pair(distance[nNode], nNode));
    //             }
    //         }
    //     }
        
    //     return distance;
        
    // }
}