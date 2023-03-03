package finished;

import java.io.*;
import java.util.*;

public class BOJ1916최소비용구하기 {
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

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        // ※주의사항※
        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
        /* TODO */
        for(int i=1 ; i<=N; i++){
            dist[i]=Integer.MAX_VALUE;
        }

        Queue<Info> que=new LinkedList<>();
        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        /* TODO */
        que.add(new Info(start,0));
        dist[start]=0;


        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!que.isEmpty()) {
            Info info = que.poll();
            int idx=info.idx;
            int minDist=info.dist;      //  start에서 idx까지의 최소비용(현재)


            //4.       que에 넣을 때 1-<5번도 넣었을 거고,  1->3->5도 넣음.
            //         근데 que에서 빼보니까  1->5는  넣은건 1->3->5보다 비용이 크네.. 그럼 5에서 가는 거 안해도되니까 continue
            // >=는 안됨. =있으면 1->5도 안하고, 1->3>5, 1->4>5 전부 edge 확인안함..
            if( minDist > dist[idx] ) continue;  //새로 들어온 경로까지의 최소비용이   기존의 idx까지의 최소비용보다 크면 폐기

            for (Edge e : edges[idx]) {
                //2.   2->4 가는걸 넣어야 하는데,   이는 1->2->4 임.  이 비용이 1->4보다 큰지 아닌지 비교해서 크면 안 넣어도 됨.
                //3.   3번차례에서는 3->4 비교하고,  3->5 비교함.      3->4는 안 넣지만, 3->5는 넣을거임
                if( dist[idx] + e.weight >=  dist[e.to]) continue;

                // 1.    처음에 1은 2,3,4,5를 다 넣는다.
                dist[e.to] = dist[info.idx] + e.weight;
                que.add(new Info(e.to, dist[e.to]));   //  dist[2](1에서 2까지 가는 최소비용) + 2에서 4까지의 비용

            }
        }
    }

    static void pro() {
        dijkstra(start);
        System.out.print(dist[end]);
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