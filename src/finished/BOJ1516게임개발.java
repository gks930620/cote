package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1516게임개발 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;


    //    5
//            10 -1   1번이 최초
//            10 1 -1   2번은 1번 지은뒤
//            4 1 -1    3번도 1번지은뒤
//            4 3 1 -1  4번은 3번 1번
//            3 3 -1   5반은 3번
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
        //뒤에 오는게 가장 늦게 지어져야 하는 것들
        for (int i = 1; i <= N; i++) {
            int time= scan.nextInt();
            T[i]=time;
            while (true){
                int x=scan.nextInt();
                if(x==-1){
                    break;
                }
                indeg[i]++;
                adj[x].add(i);
            }
        }
    }

    static void pro() {
        Deque<Integer> queue= new LinkedList<>();
        for(int i=1 ; i<=N ; i++){
            if(indeg[i]==0) {
                queue.add(i);
                T_done[i]=T[i];
            }
        }

        while (!queue.isEmpty()){
            int x=queue.poll();
            for(int y :  adj[x]){
                indeg[y]--;
                T_done[y]= Math.max( T_done[y],  T_done[x]+T[y] );
                if(indeg[y]==0) queue.add(y);
            }
        }


        for(int i=1 ; i<=N ; i++){
            System.out.println(T_done[i]);
        }

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