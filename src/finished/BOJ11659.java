package finished;

import java.io.*;
import java.util.*;

public class BOJ11659 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums=new int[N+1];
        for(int i=1 ; i<=N ; i++){
            nums[i]=scan.nextInt();
        }


    }
    static int N, M;
    static int[] nums;    // 수열
    static int[] sums;

    static void pro() {
        sums=new int[N+1];
        for(int i=1 ; i<=N ; i++){
            sums[i]+=sums[i-1]+nums[i];
        }

        for(int index=1 ; index<=M ; index++){
            int i=scan.nextInt();
            int j=scan.nextInt();
            System.out.println(sums[j] -sums[i-1]);
        }
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
