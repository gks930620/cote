package finished;

import java.io.*;
import java.util.*;

public class BOJ14888연산자끼워넣기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++)
            nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++)
            operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    static int calculator(int pre,int pmdm, int post) {
        switch (pmdm) {
            case 1:
                return pre+post;
            case 2:
                return pre-post;
            case 3:
                return pre*post;
            case 4:
                return pre/post;
        }
        return 0;
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k) {
        if (k == N) {
            // 완성된 식 (+,-,x, / 등이 완성되었을 때 그걸 계산하는 함수
            // order이 N번째는 없다. 숫자가 식보다 1개 더 많다
            int sum=nums[1];
            for(int i=1 ; i<N ; i++) {
                sum= calculator(sum, order[i],nums[i+1]);
            }
            max=Math.max(sum, max);
            min= Math.min(sum, min);
        } else {
            for(int i=1; i<=4 ; i++) {    // +,- x,/ 중에서 선택.  깊이는 무한정(K)
                if(operators[i]>=1) {
                    operators[i]--;
                    order[k]=i;
                    rec_func(k+1);
                    operators[i]++;
                    order[k]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        sb.append(max).append('\n').append(min);
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