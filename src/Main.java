import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M,W;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
        // Testcase 가 존재하는 문제이므로 "배열 초기화"에 유의하자
        /* TODO */
        N=scan.nextInt(); //건물 개수
        M=scan.nextInt(); // 규칙의 개수
        T=new int[N+1];  //단순히 건물에 걸리는 시간
        T_done=new int[N+1];   // 현재 시점에  해당 건물을 지으는데 걸리는 시간..    겹치는게 있으면 큰걸로
        indeg=new int[N+1];   //  현재 건물에 선행되어야 할 건물의 개수
        adj=new ArrayList[N+1];   //   1==>2,  1==>3     1번을 지어야 2,3번 건물을 지을 수 있다.  1번의 목적지 2개
        for(int i =1 ; i<=N ; i++){  //건물마다 걸리는 시간
            T[i]= scan.nextInt();
            adj[i]=new ArrayList<>();
        }

        for(int i=1 ; i<=N ; i++){
            int start= scan.nextInt();
            int destination = scan.nextInt();
            adj[start].add(destination);
            indeg[destination]++;  //     start에서 destination으로 가는거니까  destiantion에서는 선행되어야 건물이 start 하나 더 있다는걸 알게된거지.
        }
        W=scan.nextInt(); //목적지

    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        /* TODO */
        for(int i= 1 ; i<=N ; i++){
            if(indeg[i]==0){  //여러개일 수 있다..
                queue.add(i);
                T_done[i]=T[i];
            }
        }
        // 위상 정렬 순서대로 T_done 계산을 함께 해주기
        /* TODO */

        while (!queue.isEmpty()){
            int x= queue.poll();

            for(int y : adj[x]){  //indeg가 0이 되어야만 해당 건물을 이제 지을 수 있음
                T_done[y]= Math.max(T_done[y], T_done[x]+T[y]   );
                indeg[y] --;
                if(indeg[y]==0) {
                    queue.add(y);
                }

            }
        }

        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        int Q = scan.nextInt();
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