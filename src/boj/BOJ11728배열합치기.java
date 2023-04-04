package boj;

import java.io.*;
import java.util.*;

public class BOJ11728배열합치기 {  //2포인터지만 배열정렬로 충분
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n, m;
    static int[] a, b;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = 1;
        // a와 b를 앞에서부터 하나씩 추출해서 출력한다. 단, 둘 다 비어있지 않은 경우와 그것이 아닌 경우를 잘 나누자.
        /* TODO */
        int[] sumArray=new int[n+m];
        for(int i=0 ; i<n ; i++){
            sumArray[i]=a[i];
        }
        for(int i=n ; i<n+m ; i++){
            sumArray[i]=b[i-n];
        }
        Arrays.sort(sumArray);

        for(int ele : sumArray){
            sb.append(ele).append(" ");
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