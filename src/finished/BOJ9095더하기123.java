package finished;

import java.io.*;
import java.util.*;

public class BOJ9095더하기123 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] d;

    static void preprocess() {
        d= new int[15];
        // 초기값 구하기
        /* TODO */
        d[1]=1;
        d[2]=2;
        d[3]=4;
        // 점화식을 토대로 Dy 배열 채우기
        /* TODO */
        for(int i=4 ; i<=11 ; i++){
            d[i]=d[i-3] + d[i-2] + d[i-1];
        }
    }

    static void pro() {
        int T = scan.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int N = scan.nextInt();
            sb.append(d[N]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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