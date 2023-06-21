    import java.io.*;
    import java.lang.reflect.Array;
    import java.util.*;

    public class Main {
        static FastReader scan = new FastReader();
        static StringBuilder sb = new StringBuilder();

        static int N;
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
            for(int i=1 ; i<=N ; i++){
                T[i]= scan.nextInt();
                while (true){
                    int prev= scan.nextInt();
                    if(prev==-1 )break;
                    //i 이전에 지어져야 하는 건물==prev
                    indeg[i]++;
                    adj[prev].add(i);
                }
            }
        }

        static void pro() {
            /* TODO */
            Queue<Integer> que= new LinkedList<>();

            // 맨 먼저 지어도 될 놈들
            for(int i=1 ; i<=N  ; i++){
                if(indeg[i]==0){
                    que.add(i);
                    T_done[i]=T[i];
                }
            }

            while (!que.isEmpty()){
                int x= que.poll();
                for(int y : adj[x]){  //adj는 단방향
                    indeg[y]--;
                    T_done[y]=Math.max(T_done[y], T_done[x]+T[y] );   // 이전거까지+현재건물 합 계속 갱신해주다가
                    if(indeg[y]==0) {  //이전건물 다 지어지면 그떄서야 비로소 que에 넣음==> 짓기시작
                        que.add(y);
                    }
                }
            }


            for(int i=1 ; i<=N ; i++){
                sb.append(T_done[i]).append("\n");
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