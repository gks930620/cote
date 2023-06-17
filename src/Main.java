import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();  //강의의 개수
        M = scan.nextInt(); //내가 원하는 블루레이개수
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) { //강의의 크기.    강의의 순서 어쩌구는 의미없는 정보라는 생각이 듭니다.
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int len) {
        // TODO
    }

    static void pro() {
        int L = ?, R = ?, ans = ?;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ?
            } else {
                ?
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












