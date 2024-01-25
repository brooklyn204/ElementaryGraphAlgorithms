import java.util.Scanner;
public class Graph {
    public static int WHITE = 0;
    public static int GREY = 1;
    public static int BLACK = 2;
    public int[] v;
    public int[] c;
    public int[][] adj;
    public int[] s;
    public int[] f;
    int time;
    public Graph(int[] vertices, int[] colors, int[][] adjacencies) {
        v = vertices;
        c = colors;
        adj = adjacencies;
        s = new int[vertices.length];
        f = new int[vertices.length];
        time = 0;
    }
    public void DFS() {
        for (int u = 0; u< v.length; u++) {
            if (c[u] == WHITE) {
                DFS_visit(u);
            }
        }
    }
    public void DFS_visit(int u) {
        System.out.println(u);
        print_graph();
        c[u] = GREY;
        s[u] = ++time;
        for (int i = 0; i < adj[u].length; i++) {
            int vert = adj[u][i];
            System.out.println(vert);
            if (c[vert] == WHITE) {
                DFS_visit(vert);
            }
        }
        c[u] = BLACK;
        f[u] = ++time;
    }
    public void BFS(int source) {
        Queue Q = new Queue(source);
        while (!Q.empty()) {
            print_graph();
            int current = source;
            try {
                current = Q.get();
            } catch (Exception e) {
                System.out.println("error");
                break;
            }
            for (int i=0; i< adj[current].length; i++) {
                int vert = adj[current][i];
                if (c[vert] == WHITE) {
                    c[vert] = GREY;
                    Q.add(vert);
                }
            }
            c[current] = BLACK;
        }
    }
    public void print_graph() {
        for (int i = 0; i< v.length; i++) {
            if (c[i] == WHITE) {
                System.out.println(i + "WHITE");
            } else if (c[i] == GREY) {
                System.out.println(i + "GREY");
            } else {
                System.out.println(i + "BLACK");
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("press any key to continue:");
        scan.nextLine();
    }
//    public void print_any_path(boolean[][][] p, int i, int j) {
//        for (int k = p.length - 1; k >= 0; k--) {
//            if (p[k][i][j] == false) {
//                print_any_path(p, i, k-1);
//                System.out.println(k);
//                print_any_path(p,k+1,j);
//            }
//        }
//    }
}
