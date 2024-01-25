public class Main {
    public static void main(String[] args) {
        int[] v = {0,1,2,3,4,5,6,7,8,9};
        int[] c = {Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE,Graph.WHITE};
        int[][] adj = {{1},{2,3,4},{5,6},{6,7},{8,3,5},{},{},{9},{},{0}};
        Graph g = new Graph(v,c,adj);
//        g.DFS();
//        g.print_graph();
//        g.BFS(0);
        int inf = ShortestPaths.infinity;
//        int[][] w = {{0,3,inf,7,8},{3,0,1,4,inf},{inf,1,0,2,inf},{7,4,2,0,3},{8,inf,inf,3,0}};

        int[][] w = {{0,3,inf,5},{2,0,inf,4},{inf,1,0,inf},{inf,inf,2,0}};
        ShortestPaths s = new ShortestPaths(w);
        int[][] dn = s.FloydWarshall();
        for (int[] ints : dn) {
            for (int j = 0; j < dn[0].length; j++) {
                System.out.print("" + ints[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
        s.print_any_path(0,2);
    }
}