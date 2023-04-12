package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {  // 다시풀어보자.

    public int solution(int x ,int y ,int n) {  //x,y,n
        //BFS
        Queue<Integer> que = new LinkedList<>();
        int[] dis = new int[y + 1];



        que.add(x);  //x부터 시작..
        dis[x]=0;
        while (!que.isEmpty()) {
            int num=que.poll();

            int[] temp = new int[3];

            temp[0] = num + n;
            temp[1] = num * 2;
            temp[2] = num * 3;

            for(int i=0; i<3; i++){
                int nx=temp[i];
                if(nx>y) continue;
                if(dis[nx]==0  || dis[nx]>dis[num]+1 ){  //간적이없거나 지금가는게 더 빨리가는것인경우
                    dis[nx]=dis[num]+1;
                    que.add(nx);
                }
            }


        }
        return dis[y] ==0 ? -1 : dis[y];
    }

}
