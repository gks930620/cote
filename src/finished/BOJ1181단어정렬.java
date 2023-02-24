package finished;

import java.io.*;
import java.util.*;

public class BOJ1181단어정렬 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            // TODO
            // lhs 와 rhs 를 비교해서 lhs 가 앞에 와야 하는 조건
            // 1. 길이가 짧은 게 우선
            // 2. 길이가 같으면 사전순으로
            return 0;
        }
    }

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

    static void pro() {


        // TODO
        // 정렬 조건에 맞게 단어를 정렬하기
        Arrays.sort(a,   (o1,o2) -> {
            //음수일 때 오름차순,  양수 내림차순
            // 오름차순 : 작은거 - 큰거  /   내림차순 : 큰거 - 작은거
            // TODO
            // lhs 와 rhs 를 비교해서 lhs 가 앞에 와야 하는 조건
            // 1. 길이가 짧은 게 우선.  1   2 3 4
            // 2. 길이가 같으면 사전순으로
            if(o1.length()!=o2.length()) return  o1.length() -o2.length();
            else  //길이가 같으면 사전 순
                return o1.compareTo(o2);
        } );

        // 출력하기
        for(int i=0; i<a.length ; i++){
            if(i>=1 && a[i].equals(a[i-1])){
                continue;
            }
            sb.append(a[i]).append("\n");
        }
        System.out.println(sb.toString());
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