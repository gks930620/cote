package boj;

import java.io.*;
import java.util.*;

public class BOJ2805 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

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

    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
        long sum=0;
        for(int i=1 ; i<=N ; i++){
            sum+=A[i]-H >0 ? A[i]-H : 0;
        }
        return sum>=M ? true : false;
    }

    static void pro() {
        int L = 0, R = 2000000000, H = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        while(L<=R){
            int mid=(L+R)/2;
            if( determination(mid)){   // M 만큼 얻어 =>  더 높게 해봐야지
                L=mid+1;
                H=mid;   // 현재 최대 H로 업데이트
            }else{
                R=mid-1;    // M 만큼 못 얻어 -> 더 낮게
            }
        }
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        System.out.println(H);
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