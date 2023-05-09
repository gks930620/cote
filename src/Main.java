import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];   //  col[1]=3    1행에 3열에 체스가 놓여짐
    }

    static int N, ans;
    static int[] col;


    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;   //여기까지 온 거자체가 놓은거임
        } else {
            for (int c = 1; c <= N; c++) {    //1열부터 확인
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {   //  현재 row-1 행까지는 여왕이 놓여진 상태.  row행에 여왕을 놓을 수 있는지 확인하고 놓기
                    if (attackable( i ,col[i] , row,c )) {   //1행의 있는 여왕(i, col[i])  와  현재 행의 놓을 자리(row,  c[1부터 N까지] )
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec_func(row+1);
                    col[row]=0;
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