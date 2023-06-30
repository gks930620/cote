package boj;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ5567결혼식 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        /* TODO */
        N = scan.nextInt();
        M = scan.nextInt();
        adj=new ArrayList[N+1];
        dist=new int[N+1];
        visit=new boolean[N+1];
        for(int i=1 ; i<=N ; i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1 ; i<=M ; i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // start 라는 정점의 결혼식에 올 수 있는 사람 수 찾기
    static int bfs(int start) {
        /* TODO */
        Queue<Integer> que= new LinkedList<>();
        que.add(start);
        visit[start]=true;
        while (!que.isEmpty()){
            int x= que.poll();
            for(int y : adj[x]){
                if(visit[y]) continue;
                que.add(y);
                visit[y]=true;
                dist[y]=dist[x]+1;
            }
        }

        int sum=0;
        for(int i=2 ; i<=N; i++){
            if(dist[i] <=2 && dist[i]!=0)  sum++;
        }
        return  sum;
    }

    static void pro() {
        System.out.println(bfs(1));
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