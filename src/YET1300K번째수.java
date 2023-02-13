import java.io.*;
import java.util.*;

public class YET1300K번째수 {

    //이해하면 이분탐색 자체는 풀이가 어렵지않은데 determination 작성하기가 진짜  머리 쥐어 짜내는 느낌이다.
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static boolean determination(long candidate) {
        // candidate 이하의 숫자가 K개 이상인가?
        long sum = 0;
        // 각 행 마다 candidate 이하인 개수를 누적해보자!
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, candidate / i);
            /*
             candidate가 3일 때를 생각해보자.  
             1 2 3 4 5        1단
             2 4 6 8 10       2단
             3 6 9 12 15      3단

             3보다 작거나 같은 원소의 개수
               1단에서   3/1     3개
               2단      3/2     1개
               3단      3/3      1개         총 5개 
             4단부터는 어차피 3보다 큼
             */
        }
        return sum >= K;           // K 가 11이면     3은 5개로 만족 못함..   즉 3보다 더 큰 개수로 확인해봐야함  그래서 L=mid+1 함
    }

    static void pro() {
        long L = 0, R = N*N, ans = 0;   // ?,?,?
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        //N=100000,   NxN= 10,000,000,000   integer 초과..


        // 우리가 찾는건  B[K] =  x 에서 x
        // 반대로 x보다 작거나 같은  원소의 개수는 최소 K 개


        //그래서 결국 x를  바로 찾는게 아니라
        // x보다 작거나 같은 원소의 개수가 K인지 확인하면 된다.  이 x를 이중탐색 하는거고.
        while (L<=R){
            long mid = (L + R) / 2;
            if(determination(mid)){   // K
                ans = mid;
                R = mid - 1;
            }else {
                L=mid+1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        /*
            1  2 3
            2  4 6
            3  6 9        122334669
         */
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