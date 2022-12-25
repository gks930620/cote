import java.io.*;
import java.util.*;

public class BOJ17266어두운굴다리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt(); //줄다리 길이
        M = scan.nextInt(); //가로등 개수
        A = new int[M + 1];  //가로등의 위치  .  오름차순임
        for (int i = 1; i <= M; i++) {
            A[i] = scan.nextInt();
        }
    }


    static boolean determination(int height) {
        int last = 0;  // 밝혀진 마지막 위치
        for (int i = 1; i <= M; i++) {
            if (A[i] - last <= height) {
                last = A[i] + height;
            } else {
                return false;
            }
        }
        return last >= N;
    }

    static void pro() {
        int L = 0, R = N, ans = N;
        Arrays.sort(A, 1, M + 1);
        while(L<=R){
            int mid= (L+R)/2;
            if(determination(mid)){  //밝혀진다?   더 줄여보자
                R=mid-1;
                ans=mid;
            }else{  //안 밝혀짐.. 높여야됨
                L=mid+1;
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