import java.io.*;
import java.util.*;

public class FileSort {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 변수
    static  int N;
    static String[] files;
    static HashMap<String, Integer> map;

    public static void input(){
        N = scan.nextInt();
        files = new String[N+1];
        map = new HashMap<String,Integer>();
        for (int i =1 ; i <= N ; i++){
            files[i] = scan.nextLine();
            files[i] = files[i].substring(files[i].lastIndexOf(".")+1);
            if(!map.containsKey(files[i])){
                map.put(files[i],1 );
            }else{
                map.put(files[i],map.get(files[i])+1 );
            }
        }
    }
    public static void pro(){
//        Object[] mapkey = map.keySet().toArray();
//        Arrays.sort(mapkey);
//
//        for (String str : map.keySet()){
//            System.out.print(str+" ");
//            System.out.println(map.get(str));
//        }
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String ,Integer> entry : entryList){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
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
