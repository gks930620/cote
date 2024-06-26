package boj;

import java.io.*;
import java.util.*;

public class BOJ2252줄세우기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        // Adjacent List 생성 및 indegree 계산하기
        /* TODO */
        N= scan.nextInt();
        M=scan.nextInt();
        indeg=new int[N+1];
        adj=new ArrayList[N+1];
        for(int i=1  ; i<=N ; i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1 ; i<=M ; i++){  //단순한 입력횟수
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        /* TODO */
        for(int i=1 ; i<=N ; i++){
            if(indeg[i]==0){
                queue.add(i);
            }
        }
        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭에 "정렬 될 수 있는" 정점
        /* TODO */
        while (!queue.isEmpty()){
            int x=queue.poll();  //꺼낸게 실제로 여기에 온 거.
            sb.append(x).append(" ");
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y]==0) queue.add(y);
            }
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