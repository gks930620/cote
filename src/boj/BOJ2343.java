package boj;

import java.io.*;
import java.util.*;

public class BOJ2343 {
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

    static boolean determination(int len) {
        int cnt = 1, sum = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] > len) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }
        return cnt <= M;
    }

    static void pro() {
        int sum=0;
        for(int i=1 ; i<=N ; i++){
            sum+=A[i];
        }
        int L=1,R=sum, blueLay=0;
        for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);  // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다!
        while(L<=R){
            int mid=(L+R)/2;
            if(determination(mid)){ //  내가 찾으려는건 블루레이 최소값   M개로 담을 수 있는
                blueLay=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        System.out.println(blueLay);
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