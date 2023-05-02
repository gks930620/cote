package programers.level2;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    public static void main(String[] args) {
        String[] maps={"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int solution = new 미로탈출().solution(maps);
        System.out.println(solution);
    }

    public int solution(String[] maps) { //["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]
        int sum=0;
        dist=new int[maps.length][maps[0].length()];
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0  ; j<maps[i].length() ; j++){
                if(maps[i].charAt(j)=='S'){
                    bfs(i,j,maps);
                }
            }
        }
        //lever까지 감
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0  ; j<maps[i].length() ; j++){

                if(maps[i].charAt(j)=='L' ){
                    if(dist[i][j]==0)  return -1; //lever로 간적없다면 -1 리턴 
                    sum+=dist[i][j];
                }

            }
        }
        
        dist=new int[maps.length][maps[0].length()]; //dist초기화
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0  ; j<maps[i].length() ; j++){
                if(maps[i].charAt(j)=='L'){
                    bfs(i,j,maps);
                }
            }
        }
        for(int i=0 ; i<maps.length ; i++){
            for(int j=0  ; j<maps[i].length() ; j++){
                if(maps[i].charAt(j)=='E'){
                    if(dist[i][j]==0)  return -1; //위에서 lever로는 갔는데 출구로 간적없다면 -1 리턴 
                    sum+=dist[i][j];
                }
            }
        }
        return sum;
    }

    int[][] dist;

    public void bfs(int startX, int startY,String[] maps){  //세로, 가로   ,       leve
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Integer> que=new LinkedList<>();
        boolean[][] visit=new boolean[maps.length][maps[0].length()];  //세로, 가로
        que.add(startX);
        que.add(startY);
        visit[startX][startY]=true;
        while (!que.isEmpty()){
            int x=que.poll();
            int y=que.poll();

            for(int[] dir : directions){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length())continue;
                if(visit[nx][ny]) continue;
                if(maps[nx].charAt(ny)=='X') continue;
                visit[nx][ny]=true;
                dist[nx][ny]=dist[x][y]+1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

}
