package boj;

import java.io.*;
import java.util.*;

public class BOJ1005ACM {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    //건물은 1번부터 N번까지

    static int N, M ,W;   //건물개수,  건설순서 개수 ,    승리하기 위해 지어야 할 건물 번호
    static int[] indeg, T_done, T;    //해당 정점에 들어오는 간선 개수 ,   해당 정점까지 실행하는데 걸린 최소시간,  T(테스트케이스 아님): 해당 건물 건축시간

    static ArrayList<Integer>[] adj;   //   각 건물의 간점들      방향성이 있으니까 양쪽에서 할 필요는 없다.


    static void input() {
        // Testcase 가 존재하는 문제이므로 "배열 초기화"에 유의하자
        /* TODO */
        N=scan.nextInt();
        M=scan.nextInt();
        indeg=new int[N+1];
        T_done=new int[N+1];
        T=new int[N+1];
        adj=new ArrayList[N+1];
        for(int i=1 ; i<=N ; i++){
            T[i]=scan.nextInt();
            adj[i]=new ArrayList<>();
        }

        for(int i=1 ; i<=M ; i++){
            int start=scan.nextInt();
            int destination=scan.nextInt();
            indeg[destination]++;
            adj[start].add(destination);
        }
        W=scan.nextInt();
    }

    static void pro() {
        Deque<Integer> queue=new LinkedList<>();
        for(int i=1; i<=N ; i++){
            if(indeg[i]==0){
                queue.add(i);
                T_done[i]=T[i];
            }
        }  //시작점들 넣었지.


        while (!queue.isEmpty()){
            int x=queue.poll();
            for(int y : adj[x]){   //x에서  갈 수 있는 모든 점 조사.
                T_done[y]=Math.max(T_done[y], T_done[x]+T[y]  ) ;
                indeg[y]--;
                if(indeg[y]==0){
                    queue.add(y);
                }
            }

        }

        System.out.println(T_done[W]);



    }

    public static void main(String[] args) {
        int Q = scan.nextInt();  //테스트케이스
        while (Q > 0) {
            Q--;
            input();
            pro();
        }
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