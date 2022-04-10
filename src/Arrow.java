import java.io.*;
import java.util.*;

public class Arrow {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //변수
    static int N, ans;
    static ArrayList<Integer>[] ary;

    public static void input() {
        ans = 0 ;
    N = scan.nextInt();

    ary = new ArrayList[N+1];

        for (int i = 1 ; i <= N ; i++){
            ary[i] = new ArrayList<Integer>();
        }
    for (int i = 1 ; i <= N ; i++){
        int x = scan.nextInt();
        int y = scan.nextInt();
        ary[y].add(x);
    }
    }

    public static void pro(){
        for (int i = 1 ; i <= N ; i++){
            Collections.sort(ary[i]);
        }
        for (int i = 1 ; i <= N; i++){
            for (int j =0 ; j<ary[i].size(); j++){
                if(j==0) {
                    ans+= ary[i].get(1) - ary[i].get(0);
                }else if(j== ary[i].size()-1){
                    ans+= ary[i].get(j) - ary[i].get(j-1);
                }else{
                    int left = ary[i].get(j)- ary[i].get(j-1);
                    int right = ary[i].get(j+1) - ary[i].get(j);
                    ans += Math.min(left,right);
                }
            }
        }
        System.out.print(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
