package finished;

import java.io.*;
import java.util.*;

public class BOJ15649 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used=new int [N+1];
    }

    static int N, M;
    static int[] selected,used;
    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름   => 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        //이번엔 중복 제거
        if(k==M+1){
            //다 골랐다.
            for(int i=1; i<=M ; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=1 ; i<=N ; i++){
                if(used[i]==1){  //i는 사용된적이 있다.
                    continue;
                }else{
                    selected[k]=i;
                    used[i]=1;
                    rec_func(k+1);
                    used[i]=0;
                    selected[k]=0;
                }

            }
        }
    }

    private static boolean notHasSelectedI (int k, int findI) {
        for(int i=1; i<=k ; i++){
            if(selected[i]==findI){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
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