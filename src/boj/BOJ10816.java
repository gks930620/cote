package boj;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] A,B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B=new int[M+1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static void pro() {
        //해쉬맵을 이용해 풀어보겠다... 이분탐색 상한 하한 실패 ㅠ
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=N ; i++){
            map.put( A[i], map.getOrDefault(A[i],0)+1 );
        }

        for(int i=1 ; i<=M ; i++){
            sb.append(map.getOrDefault(B[i],0)).append(" ");
        }
        System.out.println(sb.toString());


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
