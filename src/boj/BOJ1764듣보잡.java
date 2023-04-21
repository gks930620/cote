package boj;

import java.io.*;
import java.util.*;

public class BOJ1764듣보잡 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, B, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        B = new String[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLine();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.next();
        }
    }

    static boolean bin_search(String[] B, int L, int R, String X) {
        // B[L ... R] 이 정렬되어 있다고 가정했을 때
        // 이 안에서 X 를 이분탐색하고, 존재하면 true, 아니면 false 를 return 하는 함수
        while (L<=R){
            int mid= (L+R)/2;
            if(X.compareTo(B[mid]) <0){  //찾으려는게 더 뒤에있으면  .  X=A,  B[mid]=B   ,  mid가 줄어들어야지
                R=mid-1;
            }else if(X.compareTo(B[mid]) > 0) {   //찾으려는게 더 앞에있으면
                L=mid+1;
            }else{ //같음
                return  true;
            }
        }
        return false;
    }

    static void pro() {
        // 보도 못한 사람들을 입력 받으면서 듣도 못한 사람들 안에서 찾아주기
        // 정답을 기록해서 사전순으로 출력해주기
        Arrays.sort(A,1,N);
        Arrays.sort(B,1,M);

        List<String> list = new ArrayList<>();
        int count=0;
        for (int i = 1; i <= N; i++) {
            String cand = A[i];   //A[i]를 B에서 찾아보자. 이분탐색으로
            if(bin_search(B, 1,M,cand)){  //있으면 추가하자
                list.add(cand);
            }
        }
        list.sort(null);
        sb.append(list.size()).append("\n");
        for(String 듣보 : list){
            sb.append(듣보).append("\n");
        }
        System.out.println(sb);
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