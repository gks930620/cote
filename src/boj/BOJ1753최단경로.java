package boj;

import java.io.*;
import java.util.*;

public class BOJ1753최단경로 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {
        }

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, K;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K=scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        // ※주의사항※
        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
        /* TODO */
        for(int i=1 ; i<=N ; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        // 최소 힙 생성
        /* TODO */
        PriorityQueue<Info> pq= new PriorityQueue<>( (o1, o2) -> o1.dist-o2.dist );  //작은게 앞에온다. 기억하자. 작은게 앞에온다.

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        /* TODO */
        pq.add(new Info(start,0));
        dist[start]=0;
        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            int idx=info.idx;
            int minDist=info.dist;

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
            /* TODO */
            if(minDist> dist[idx]){
                //이번문제에 한해서 이 경우는 없다
                //이번문제에서는 1->2->4가 먼저 pq에 들어가고
                //  1-3-4 를 넣으려고 dist 비교해보는데 1-2-4가 더 짧아서 안들어간다.

                //  input에 2-4 로 가는 가중치를 5대신  10으로 넣으면 이 if문이 실행된다. (주의. 처음부터 하나하나 직접입력해야함. 복붙하고 해당부분만 바꾸면 잘 안됨)


                // 1-2-4가 먼저 pq에 들어간 다음
                //  1-3-4를 pq에 넣으려고 한다.  dist[4]가   1-3-4의 경우로 수정되고   pq에 들어간다.
                //  이러면 pq에는  1-2-4,  1-3-4가 둘다 들어가있다.
                // pq니까  1-3-4 가 먼저나온다.
                // 나중에 나온 1-2-4는 이미 최단경로가 아니기 때문에    밑의 for문을 실행할 필요없다.
                System.out.println("여기 나오나..");
                continue;
            }

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for (Edge e : edges[info.idx]) {
                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
                /* TODO */
                // 1->2->3이  1->3보다 크냐
                if( dist[e.to]  <=  dist[idx]+e.weight  ) continue;;
                dist[e.to]=dist[idx]+e.weight; //  만약 1->2->3이 더 작으면   1->2->3 경로로 업데이트
                pq.add(new Info(e.to,dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(K);
        /* TODO */
        for(int i=1; i<=N ; i++){
            if(dist[i]==Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
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