import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] D;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        D = new int[N + 1][10];   //마지막이 1로 끝나면 Dy[N][1]
    }

    static void pro() {
        // 초기값 구하기
        /* TODO */
        for(int i=0; i<10 ; i++ ){
            D[1][i]=1;
        }

        // 점화식을 토대로 Dy 배열 채우기
        /* TODO */
        for(int i=2 ; i<=N ; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j ; k++){
                    D[i][j]+=D[i-1][k];
                    D[i][j]%=10007;
                }
            }
        }

        // Dy배열로 정답 계산하기
        int sum=0;
        for(int i=0 ; i<10 ; i++){
            sum+=D[N][i];
            sum%=10007;
        }
        System.out.println(sum);
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