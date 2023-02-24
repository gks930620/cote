package finished;

import java.io.*;
import java.util.*;

public class BOJ6236 {
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

    static boolean determination(int withdrawl) {  //m번보다 많이 인출해야만 한다=>false   적게 인출하는경우는 내 맘대로 다시 인출 가능. true
        // TODO
        int count=1;
        int sum=0;
        for(int i=1 ; i<=N ; i++){
            if(  withdrawl <sum+A[i] ){  //초과하면
                count++;
                sum=0;
            }
            sum += A[i];
        }
        return count>M ? false : true;
    }

    static void pro() {
        int max=A[1];
        for(int i=2 ; i<=N ; i++){
            max=Math.max(max,A[i]);
        }
        int L = max, R = 1000000000, ans = 0;   // R은 충분히 커야되고   L 은 적어도 하루 사용금액보다는 커야.

        while(L<=R ){
            int mid=(L+R)/2;
            if( determination(mid)){    // m번  이하로 인출 가능 => 돈 더 줄여봐.
                R=mid-1;
                ans=mid;
            }else{        //많이 인출해야만한다 ?  돈 더 늘려야지..
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