package finished;

import java.io.*;
import java.util.*;

public class BOJ2230수고르기 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        // 투 포인터 기법을 쓰기 위해서 정렬 해주기
        /* TODO */
        Arrays.sort(A,1,N+1);
        int R = 1, ans = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            //sum이 아니니까 왼쪽 제외할 필요x

            // 필요한 만큼 R을 오른쪽으로 이동 시키기
            while (R+1<=N && A[R]-A[L]<M){
                R++;
            }

            if(A[R]-A[L]>=M) ans=Math.min(ans,A[R]-A[L]);   //if쓴 이유는 R+1 <=N  조건에서 걸렸을 수도 있으니까..
        }

        System.out.println(ans);
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