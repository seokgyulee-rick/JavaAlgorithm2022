import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Card {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //변수
    static long  cnt, max, ans;
    static long[] ary ;
    static int N;


    public static void input() {
        N = scan.nextInt();
        cnt = 0;
        max = 0;
        ans = 0;
        ary = new long[N];
        for (int i = 0 ; i< N ; i++){
            ary[i] = scan.nextLong();
        }
    }

    public static void pro(){
        Arrays.sort(ary);
        for (int i = 0 ; i < N ; i++){
            if(i == 0 ) {
                cnt++;
            }
            else if(ary[i] == ary[i-1]){
                cnt++;
            }else{
                cnt = 1;
            }
//            System.out.println("-----");
//            System.out.println(cnt);
//            System.out.println(max);
            if(cnt >max){
//                System.out.println(ary[i]);
                max = cnt;
                ans = ary[i];
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.print(ans);
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
