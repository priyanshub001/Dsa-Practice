class Solution {
      int nodes;
    int degree;
    public int countCompleteComponents(int n, int[][] edges) {
         ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(int[] e: edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];

        int ans=0;

        for(int i=0;i<n;i++){

            if(!vis[i]){

                nodes=0;
                degree=0;

                dfs(i,graph,vis);

                int totalEdges = degree/2;

                if(totalEdges == nodes*(nodes-1)/2)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int curr, ArrayList<Integer>[] graph, boolean[] vis){

        vis[curr]=true;

        nodes++;
        degree += graph[curr].size();

        for(int nei: graph[curr]){
            if(!vis[nei]){
                dfs(nei,graph,vis);
            }
        }
    }
}