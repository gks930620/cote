package boj;

import java.io.*;
import java.util.*;

public class BOJ2056작업 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        T_done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for( int i=1 ; i<= N ; i++){
            T[i]=scan.nextInt();
            int preCount= scan.nextInt();
            for(int j=1 ; j<=preCount ; j++){
                indeg[i]++;  //선행 작업  올 때마다 ++
                int a=scan.nextInt();
                adj[a].add(i);
            }
        }

    }

    static void pro() {
        Deque<Integer> que= new LinkedList<>();
        for(int i=1 ; i <=N ; i++){
            if(indeg[i]==0){
                que.add(i);   // 선행작업이 없는 번호들 que에 넣기
                T_done[i]=T[i];   //선행작업이 없는 번호들을 끝마치는데는  해당 작업의 시간만 필요함
            }
        }


        while (!que.isEmpty()){
            int x=que.poll();
            for(int y : adj[x]){
                T_done[y]=Math.max(T_done[y],T_done[x]+T[y] ) ;  //현재 y번까지 작업한 결과들 중 최대값
                indeg[y]--;    //선행작업1개 완료함
                if(indeg[y]==0){   // 선행작업 모두 완료했으면 que에 넣기.
                    que.add(y);
                }
            }
        }

        //마지막게 아니라 모든 작업 최대화
        int max=0;
        for(int i=1 ; i<=N ; i++){
            max=Math.max(max, T_done[i]);
        }
        System.out.println(max);
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