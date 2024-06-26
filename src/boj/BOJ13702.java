package boj;

import java.io.*;
import java.util.*;

public class BOJ13702 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(long amount) {
        // TODO
        int count=0;
        for(int i=1 ; i<=N ; i++){
            long sum=0;
            while(sum+amount <= A[i]){   //초과전까지
                sum+=amount;
                count++;
            }
        }
        // K 이상에게 나눠줄 수 있으면 true  없으면 false
        return count>=K;
    }

    static void pro() {
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        // TODO
        while(L<=R){
            long mid=(L+R)/2;
            if(determination(mid)){     //mid의 최대값 찾기,   k 이상에게 나눠줄 수 있는가?   있으면   용량 늘려봐야지
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