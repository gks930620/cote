package boj;

import java.io.*;
import java.util.*;

public class BOJ2667단지번호붙이기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][N];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visit 체크 하기
        /* TODO */
        visit[x][y]=true;  //현재 온 곳 true
        //방문처리
        group_cnt++;


        for(int[] direction : dir){   // (x,y)에서 갈 수 있는 모든 곳 조사.
            int nextX=x +direction[0] ;
            int nextY=y+direction[1];
            //지도 영역 넘어가나?   작은것도
            if(nextX >=N || nextY >=N  || nextX <0 || nextY<0 ) continue;
            //  다른단지인지
            if(  a[nextX].charAt(nextY)=='0'  ) continue;
            //방문한적은?
            if(visit[nextX][nextY] ==true ) continue;
            //다 만족했으면 가자
            dfs(nextX,nextY);
        }
    }

    static void pro() {
        group = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    // 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지인 경우!
                    /* TODO */
                    group_cnt=0;
                    dfs(i,j);  // (i,j) 에서 갈 수 있는 모든걸 뒤집니당.
                    group.add(group_cnt);
                }
            }
        }

        // 찾은 단지의 정보를 출력하기
        /* TODO */
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(int danziCount : group){
            sb.append(danziCount).append("\n");
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