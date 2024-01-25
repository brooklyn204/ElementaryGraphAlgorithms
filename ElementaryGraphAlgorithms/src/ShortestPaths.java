public class ShortestPaths {
    public static int infinity = 10000;
    public int[][] W;
    private int[][] D;
    private boolean pDinit = false;
    private boolean[][][] p;
    public ShortestPaths(int[][] weights) {
        W = weights;
    }
    public void print_graph() {
        for (int[] ints : W) {
            for (int j = 0; j < W[0].length; j++) {
                System.out.print("" + ints[j] + " ");
            }
            System.out.print("\n");
        }
    }
    public void print_path_lengths() {
        if (!pDinit) {
            FloydWarshall();
        }
        for (int[] ints : D) {
            for (int j = 0; j < D[0].length; j++) {
                System.out.print("" + ints[j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] FloydWarshall() {
        D = new int[W.length][W[0].length];
        p = new boolean[W.length][W.length][W[0].length];
        for (int i = 0; i<W.length; i++) {
            System.arraycopy(W[i], 0, D[i], 0, W[0].length);
        }
        for (int k = 0; k < W.length; k++) {
            for (int i=0; i<W.length; i++) {
                for (int j=0; j<W.length; j++) {
                    if (D[i][j] > D[i][k] + D[k][j]) {
                        p[k][i][j] = true;
                    } else {
                        p[k][i][j] = false;
                    }
                    D[i][j] = Math.min(D[i][j],D[i][k] + D[k][j]);
                }
            }
        }
        this.pDinit = true;
        return D;
    }
    public void print_p(int i) {
        for (boolean[] row : p[i]) {
            for (int j = 0; j < row.length; j++) {
                System.out.print("" + row[j] + " ");
            }
            System.out.print("\n");
        }
    }
    public void print_any_path(int i, int j) {
        System.out.print(i+"-");
        print_any_path_helper(i,j,p.length-1);
        System.out.print(j);
    }
    public void print_any_path_helper(int i, int j, int k) {
        if (k <= 0) {
            return;
        }
//        System.out.println("i,j are "+ i + " "+ j);
        if (p[k][i][j]) {
            print_any_path_helper(i, k,k-1);
            System.out.print(k+"-");
            print_any_path_helper(k,j,k-1);
        } else {
            print_any_path_helper(i,j,k-1);
        }
    }
}
