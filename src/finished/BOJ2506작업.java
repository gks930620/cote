package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ2506작업 {
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
        /* TODO */
        for (int i = 1; i <= N; i++) {
            int time = scan.nextInt();
            T[i] = time;

            int preCount = scan.nextInt();
            for (int j = 0; j < preCount; j++) {
                int pre = scan.nextInt();
                adj[pre].add(i );     //pre에서 i 로 가는거니까...
                indeg[i]++;
            }
        }
    }

    static void pro() {
        /* TODO */
        Deque<Integer> queue= new LinkedList<>();
        for(int i=1 ; i<=N ; i++){
            if(indeg[i]==0) {
                queue.add(i) ; //첫 시작 점들
                T_done[i] = T[i];   //이거 빼먹으면 안되지...
            }
        }
        while (!queue.isEmpty()){
            int x=queue.poll();
            for(int y : adj[x]){
                indeg[y]--;
                T_done[y]=Math.max(T_done[y], T[y]+T_done[x]  );
                if(indeg[y]==0) queue.add(y);
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=1; i<=N ; i++){
            max=Math.max(max,T_done[i]);
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