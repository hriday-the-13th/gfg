
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // code here
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
        
        return adjList;
    }
}