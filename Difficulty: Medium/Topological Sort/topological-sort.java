class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adjList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        
        
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            
            adjList.get(u).add(v);
        }
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adjList, vis, stack);
            }
        }
        
        ArrayList<Integer> retList = new ArrayList<>();
        
        while(!stack.isEmpty()){
            retList.add(stack.pop());
        }
        
        return retList;
    }
    
    public void dfs(int node, List<List<Integer>> adjList, boolean[] vis, Stack<Integer> stack){
        vis[node] = true;
        for(int neighbour: adjList.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour, adjList, vis, stack);
            }
        }
        stack.push(node);
    }
}