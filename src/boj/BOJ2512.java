package boj;

import java.io.*;
import java.util.*;

public class BOJ2512 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static boolean determination(int limit) {  //1원만 주면 되긴하지..  예산초과 false,    돈 줄수있으면 true
        // TODO
        int sum=0;
        for(int i=1; i<=N ; i++){
            sum +=   A[i]>limit ? limit : A[i];
        }
        return sum> M ? false : true;
    }

    static void pro() {
        int max=0;
        for(int i=1 ; i<=N ; i++){
            max=Math.max(A[i],max);
        }

        int L=1, R=max, ans=0; //
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R){
            int mid=(L+R)/2;
            if(determination(mid)){ //줄 수 있으면 상한액 더 늘려.
                L=mid+1;
                ans=mid;
            }else{
                R=mid-1;
            }
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