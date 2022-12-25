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
    static int[] col;   // index는 row, 값은  열

    //(r1,c1)이 (r2,c2)를 공격할 수 있는지
    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 == r2) return true;  //이런일은 rec_func에서 일어나지않지만 함수정의때문에 써봄.
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }


    //rec_fun row는 행,  for의 i는 열
    // 행
    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int i = 1; i <= N; i++) {  // 1열부터 N열까지 다 찾음.
                boolean possible=true ;    //일단 놓을 수 있음.
                for(int j=1 ; j<=row-1; j++){   //현재 1행부터 row-1 행까지의 놓인 퀸들을 전부 조사.
                    if(attackable(j,col[j],row,i)){  //(r2,c2)는 현재 놓으려는 곳  (r1,c1)은 놓여져있는곳
                        possible=false;
                        break;
                    }
                }
                if(possible){
                    col[row]=i;
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