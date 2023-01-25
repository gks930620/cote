import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];   // operatios[1]    + 의 개수
        order = new int[N + 1];
        for (int i = 1; i <= N; i++)
            nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++)
            operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;    //order는  연산을 진행한 결과값 저장   order[1]=nums[1],   order[2]  는  nums[1]과 nums[2]를 연산(사칙연산중 하나) 한 결과

    static int calculator(int pre, int pmdm, int post) {
        switch (pmdm){
            case 1 :
                return pre+post;
            case 2 :
                return pre-post;
            case 3 :
                return pre*post;
            case 4 :
                return pre/post;
        }

        return 0;
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int depth) {
        if (depth == N + 1) {
            max=Math.max(max, order[N]);
            min=Math.min(min,order[N]);
            return;
        }
        if (depth == 1) {
            order[1] = nums[1];
            rec_func(2);
        }

        if (depth >= 2) {
            for (int i = 1; i <= 4; i++) {
                //operator에서 개수 없애야지..
                if (operators[i] == 0) continue;
                order[depth] = calculator(order[depth - 1], i, nums[depth]);
                operators[i]--;
                rec_func(depth + 1);
                operators[i]++;  //연산자 다시 돌려줘야지

            }
        }

    }

    public static void main(String[] args) {
        input();
        rec_func(1);
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