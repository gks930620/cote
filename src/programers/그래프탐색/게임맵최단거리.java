package programers.그래프탐색;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int solution(int[][] maps) {
        int m= maps.length; //세로
        int n=maps[0].length;   //가로
        boolean[][] visit=new boolean[m][n];   //세로 가로
        int[][] dist= new int[m][n];   //m,n까지 가는데 걸린 거리

        
        Queue<Integer> que= new LinkedList<>();   //세로 가로 순
        que.add(0);
        que.add(0);
        visit[0][0]=true;
        dist[0][0]=1;
        while (!que.isEmpty()){
            int x=que.poll();  //세로
            int y= que.poll();  //가로
            for(int[] direction : dir){
                int nx=  x+direction[0];
                int ny= y+direction[1];
                if( nx>=m || ny>=n  || nx<0 || ny<0) continue; //범위
                if(visit[nx][ny]) continue; //방문
                if(maps[nx][ny]==0)  continue; //벽

                dist[nx][ny]=dist[x][y]+1;
                visit[nx][ny]=true;
                que.add(nx);
                que.add(ny);
            }
        }

        return dist[m-1][n-1]==0 ? -1 : dist[m-1][n-1];
    }
}
