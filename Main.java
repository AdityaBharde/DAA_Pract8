
class Main {
    public static boolean isSafe(int v, int[][] graph , int[] color, int c ){
        int V= graph.length;
        for(int i= 0 ;i<V;i++){
            if(graph[v][i]== 1 && color[i]==c){
                return false;
            }
        }
        return true;
    }
    public static boolean graphColor(int[][] graph , int m , int[] color , int v){
        int V= graph.length;
        if(v==V){
            return true;
        }
        for(int c = 1 ; c<=m ;c++){
            if(isSafe(v,graph,color,c)){
                color[v]=c;
                if(graphColor(graph,m,color,v+1)){
                    return true;
                }
                color[v]=0;
            }
        }
        return false;
    }
    public static void solveGraph(int[][] graph, int m){
        int V=graph.length;
        int[] color = new int [V];
        if(!graphColor(graph,m,color,0)){
            System.out.println("No Graph possible.");
            return;
        }
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex-\t"+i+"\tC"+color[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,1,1,0,1,1},
                {1,0,1,0,0,0},
                {1,1,0,1,0,0},
                {0,0,1,0,1,0},
                {1,0,0,1,0,1},
                {1,0,0,0,1,0}
        };
        int m = 3;
        solveGraph(graph,m);
    }


}
