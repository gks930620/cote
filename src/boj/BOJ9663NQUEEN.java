package boj;

import java.io.*;
import java.util.*;

public class BOJ9663NQUEEN {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;   // col[1]=3     1번째 줄 3번째 칸의 돌   (1,3)

    // 기존에 있던 거   r1,c1       현재 놓으려는 곳 r2,c2
    static boolean attackable(int r1, int c1, int r2, int c2) {  //공격이 가능하면 true
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        // abs쓰면 안되는 이유는 그림보면 이해 될거임.
        // (3,5)면 (1,3),(2,4) ,(4,6) (5,7)  비교해야되는데
        // 절대값이면 (4,2)도 대각선에 있는걸로 판단함.
        // (-)는 /  대각선이고,       (+)는 \ 대각선  .   그래서 abs 쓰면안됨.  근데 왜 다른곳에는 abs 썻었냐 .ㅅㅂ
        return false;
    }

    static void rec_func(int depth) {
        if (depth == N + 1) {
            // TODO
            ans++;
        } else {
            // TODO
            for(int i=1 ; i<=N ; i++){
                //attackable 메소드는 1개의 돌에 대해서만... 그러므로  모든 돌 조사해야됨.
                boolean isSafeFromAllQueen= true;  //첨엔 공격 안 당한다고 본다
                for(int j=1 ; j<depth ; j++){    // 1번째부터  이전 depth까지의 돌들 조사.
                    if(attackable(  j , col[j]  ,  depth , i )){
                        isSafeFromAllQueen=false;
                    }
                }
                if(isSafeFromAllQueen){  //모든 퀸으로부터 안전하면
                    col[depth]=i;  //현재 칸에 퀸 넣고  다음 줄 확인
                    rec_func(depth+1);
                    col[depth]=0;
                }

            }

        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
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