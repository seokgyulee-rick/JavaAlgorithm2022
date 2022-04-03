import java.io.*;
import java.util.StringTokenizer;

public class onefoureieiei {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        used = new int[5];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
            used[i] = 0 ;
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order, used;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2){
        // TODO
        if(operator == 1){
            return operand1 + operand2;
        }else if(operator ==2 ){
            return operand1 - operand2;
        }else if(operator ==3){
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
    }


    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k, int value) {
//        System.out.println("rec_func " + k +" "+ value+ " "+ N);
        if (k == N) {
//            System.out.println(" k == N ");
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            // TODO

            if( value > max) max = value;
            if ( value < min) min = value;
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            // TODO
            for (int i = 1 ; i <=4 ; i++){
                int tempVal;
                if(used[i] != operators[i]&& operators[i] != 0 ){
                    used[i] += 1;
//                    System.out.println("value = "+ value);
//                    System.out.println("value 2 = "+ nums[k+1]);
//                    System.out.println("i = "+ i );
                    tempVal =  calculator(value,i, nums[k+1] );
//                    System.out.println(value);
                    rec_func(k+1,tempVal);
                    used[i] -= 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
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