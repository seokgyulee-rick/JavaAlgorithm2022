import java.io.*;
import java.util.StringTokenizer;

public class oneoneeighttwo {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //변수
    static int N, ans, cnt=0;
    static int [] ary,select, picked;

    public static void input(){
        N = scan.nextInt();
        ans = scan.nextInt();
        ary = new int[N+1];
        select = new int[N+1];
        picked = new int[N+1];
        for (int i =1 ; i<=N; i++){
            ary[i] = scan.nextInt();
        }
    }
    public static void recur_pro(int k, int target ){
        if(k == target || target > N - k){
            int sum = 0;
            for (int j = 1 ; j <= target ; j++){
                sum += select[j];
            }
            if(sum == ans) cnt++;
        }
        else{
            for (int t = 1 ; t<=N; t++){
                if(picked[t] == 0){
                    select[k] = t;
                    picked[k] = 1;
                    recur_pro(k+1,target);
                    select[k] = 0;
                    picked[k] = 0 ;
                }
            }

        }
    }

    public static void main(String[] args) {
        input();
        for (int i = 1; i <= N; i++){
            for (int j =1 ;j <= N ; j++){
                recur_pro(j,i);
            }
        }
        System.out.println(cnt);
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
