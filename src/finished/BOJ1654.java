package finished;

import java.io.*;
import java.util.*;

public class BOJ1654 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(long len) {
        // len 만큼의 길이로 랜선들을 잘랐을 때, N 개 만큼의 랜선을 얻을 수 있는가?
        int sum=0;
        for(int i=1 ; i<=K; i++){
            sum+=A[i]/len;
        }
        return sum<N ? false : true;
    }


    // int로 해도 되는 범위인데 L+R했을 때  int 범위 초과함
    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R){
            long mid=(L+R)/2;    //랜선의 길이는 2^31-1   int 범위
            if(determination(mid)){     // n개를 얻을 수 있다? 더 키워야지
                L=mid+1;
                ans=mid;
            }else{
                R=mid-1;  //n개 못 얻었다.  더 작게
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