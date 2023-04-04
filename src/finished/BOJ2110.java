package finished;

import java.io.*;
import java.util.*;

public class BOJ2110 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int D) {
        // D 만큼의 거리 차이를 둔다면 C 개 만큼의 공유기를 설치할 수 있는가?
        // 제일 왼쪽 집부터 가능한 많이 설치해보자!
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 를 비교하자.
        int cnt = 1, last = A[1];     //현재 1번에 설치 함
        for(int i=2; i<=N ; i++){
            if(A[i] - last  >=  D){
                last=A[i];
                cnt++;
            }
        }
        return cnt >= C;
    }

    static void pro() {
        // determination을 빠르게 하기 위해서 정렬해주자.
        Arrays.sort(A,1,N+1);

        int L = 1, R = 1000000000, C = 1000000000;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while (L<=R){
            int mid= (L+R)/2;
            if(determination(mid)){   //거리가  최대일때를 계속 찾는거지.  거리가 큰 데 C개 이상 설치 가능? => 거리 더 늘려
                L=mid+1;
                C=mid;
            }else{
                R=mid-1;
            }
        }

        System.out.println(C);
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