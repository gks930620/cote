import java.io.*;
import java.util.*;

public class BOJ1806부분합 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n, S;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        S = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
    }

    //강의에서는 필요없는 L부분은 확인할 필요 없는 것 처럼 했지만 실제로는 for문으로 한번은 확인.. S가 while문 바로 탈출하고 그 다음 L 확인하는 식임.
    static void pro() {
        int R = 0, sum = 0, ans = n + 1;  //ans 는 가장 짧은 길이
        for (int L = 1; L <= n; L++) {
            // L - 1 을 구간에서 제외하기
            sum-=a[L-1];
            // R 을 옮길 수 있을 때 까지 옮기기
            while (R+1<=n &&  sum<S){  //R이 구간 넘어가는지도 확인
                R++;
                sum+=a[R];
            }
            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if(sum>=S){   //위의 while문에서 구간을 넘어가는 경우도 있으니까..
                ans=Math.min(ans,R-L+1);
            }
        }

        // ans 값을 보고 불가능 판단하기
        if(ans==n+1){
            ans=0;
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