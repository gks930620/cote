import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        /* TODO */
        N= scan.nextInt();
        M= scan.nextInt();
        visit=new boolean[N+1];
        adj=new ArrayList[N+1];
        for(int i=1 ; i<=N ; i++){
            adj[i]=new ArrayList<>();
        }
        for(int i = 1; i<=M ; i++){
            int start= scan.nextInt();
            int end= scan.nextInt();
            adj[start].add(end);
            adj[end].add(start);  //양방향
        }

    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        /* TODO */
        Queue<Integer>  queue=new LinkedList<>();
        queue.add(start);
        visit[1]=true;

        while (!queue.isEmpty()){
            int x= queue.poll();

            for(int y : adj[x]){
                if(visit[y]==true) continue;
                queue.add(y);
                visit[y]=true;
            }
        }
    }

    static void pro() {
        /* TODO */
         bfs(1);
         int count=0;
         for(int i=2 ; i<=N ; i++){  //1은 포함시키지말라고했지
             if(visit[i]){
                 count++;
             }
         }
        System.out.println(count);
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