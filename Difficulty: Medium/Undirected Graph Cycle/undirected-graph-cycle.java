class Solution {
    public record Pair(int curr, int prev){}
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                queue.add(new Pair(i, -1));
                visited[i] = true;
                if (bfs(adjList, queue, visited)) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean bfs(List<List<Integer>> adjList, Queue<Pair> queue, boolean[] visited){
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int curr = pair.curr();
            int prev = pair.prev();
            for(int i=0; i<adjList.get(curr).size(); i++){
                int neighbour = adjList.get(curr).get(i);
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new Pair(neighbour, curr));
                } else if(prev != neighbour){
                    return true;
                }
            }
        }
        
        return false;
    }
}