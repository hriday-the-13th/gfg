class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] visitedPrime = new boolean[V];
        boolean[] visitedSecond = new boolean[V];
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(v);
        }
        
        
        for(int i=0; i<V; i++){
            if(!visitedPrime[i]){
                if(dfs(i, adjList, visitedPrime, visitedSecond)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int startNode, List<List<Integer>> adjList, boolean[] visPrime, boolean[] visSecond){
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(startNode);
        visPrime[startNode] = true;
        visSecond[startNode] = true;
        
        
        // while(!queue.isEmpty()){
        //     int curr = queue.poll();
            for(int neighbour: adjList.get(startNode)){
                if(!visPrime[neighbour]){
                    if(dfs(neighbour, adjList, visPrime, visSecond)) return true;
                } else if(visSecond[neighbour]){
                    return true;
                }
            }
            visSecond[startNode] = false;
        
        return false;
    }
}