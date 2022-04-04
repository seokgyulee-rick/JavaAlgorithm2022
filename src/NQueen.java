import java.io.*;
import java.util.StringTokenizer;

public class NQueen {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //변수
    static int N, ans = 0 ;
    static int[][] map;
    public static void input(){
        N = scan.nextInt();
        map = new int[N+1][N+1];
        for (int i = 1 ; i<=N; i++){
            for (int j = 1 ; j <=N ; j++){
                map[i][j] = 0;
            }
        }
    }

    public static boolean isPossible(int row, int col){
        for (int i = 1 ; i<row; i++){
            for (int j = 1 ; j <=N ; j++){
                if(map[i][j]==1){
                    if(col == j) return false;
                    if(Math.abs(i-row) == Math.abs(j-col)) return false;
                }
            }
        }
        return true;
    }
    public static void func_recur(int k ){
        if(k == N+1){
            ans++;
        }else{
            for (int i = 1 ; i<=N  ; i++)
                if(isPossible(k,i)){
                    map[k][i] = 1;
                    func_recur(k+1);
                    map[k][i] = 0 ;
                }
        }
    }

    public static void main(String[] args) {
        input();
        func_recur(1);
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
