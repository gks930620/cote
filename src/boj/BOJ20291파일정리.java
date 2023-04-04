package boj;

import java.io.*;
import java.util.*;

public class BOJ20291파일정리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            // 입력된 파일 이름을 . 을 기준으로 나눠서 확장자를 가져오기
            String str=scan.next();
            a[i]=str.split("\\.")[1];
        }
    }

    static void pro() {
        // TODO: 확장자마다 몇 번 나타났나 count 하기
        // 확장자 오름차순,  각 확장자가 몇개있는지
        // txt 2,  world 1
        Map<String,Integer> map= new HashMap<>();   // txt , 2  <key,value>
        for(String str : a){
            map.put(str, map.getOrDefault(str,0)+1 );
        }
        Set<String> set = map.keySet();
        List<String > list= new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);

        for(String str : list){
            sb.append(str).append(" ").append(map.get(str));
            sb.append("\n");
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