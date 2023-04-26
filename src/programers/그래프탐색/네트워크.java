package programers.그래프탐색;

import javax.sound.sampled.Line;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 네트워크 {

    public static void main(String[] args) {
        int[][] com= 	{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int solution = new 네트워크().solution(3, com);
        System.out.println(solution);
    }
    boolean[] visit;

    public int solution(int n, int[][] com) {
        visit=new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {    //0번부터 n-1
            if (visit[i] == false) {
                bfs(i, com);
                answer++;
            }
        }
        return answer;
    }


    public void bfs(int start, int[][] com) {  //갈 수 있는 모든점=> com에 있지.
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 0; i < com[x].length; i++) {  //x의 연결정보
                if (com[x][i] == 1   && visit[i]==false) {   //1인것만 올 수 있는 점들   그중 실제로 연결된 것들
                    que.add(i);
                    visit[i]=true;
                }
            }
        }
    }


}
