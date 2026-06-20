class Solution {
    public record Pair(int vertex, int weight){}
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adjList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        int[] distance = new int[V];
        
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[0] = 0;

        
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            adjList.get(u).add(new Pair(v, weight));
        }
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfsTopo(i, adjList, stack, vis);
            }
        }
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            
            for(Pair neighbour: adjList.get(node)){
                int vertex = neighbour.vertex();
                int weight = neighbour.weight();
                
                if(distance[node] != Integer.MAX_VALUE){
                    distance[vertex] = Math.min(distance[vertex], distance[node] + weight);
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        
        return distance;
    }
    
    public void dfsTopo(int node, List<List<Pair>> adjList, Stack<Integer> stack, boolean[] vis){
        vis[node] = true;
        for(Pair neighbour: adjList.get(node)){
            int vertex = neighbour.vertex();
            if(!vis[vertex]){
                dfsTopo(vertex, adjList, stack, vis);
            }
        }
        stack.push(node);
    }
    
    
    
}