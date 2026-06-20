class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        // Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[adj.size()];
        
        ArrayList<Integer> retList = new ArrayList<>();
        
        
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                dfsHelper(i, adj, visited, retList);
            }
        }
        
        // while(!stack.isEmpty()){
        //     retList.add(stack.pop());
        // }
        
        // Collections.reverse(retList);
        return retList;
        
    }
    
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> stack){
        vis[node] = true;
        stack.add(node);
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                dfsHelper(neighbour, adj, vis, stack);
            }
        }
       
    }
}