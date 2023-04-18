package programers.완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망나누기 {
    public static void main(String[] args) {
        int[][] wires= {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int solution = new 전력망나누기().solution(7, wires);
        System.out.println(solution);
    }


    ArrayList<Integer>[] nodes;
    int min=Integer.MAX_VALUE;
    boolean visit[];
    public  int solution(int n, int[][] wires) {  //개수세는거는 어떡하지?
        visit=new boolean[n+1];
        nodes=new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++){
            nodes[i]= new ArrayList<>();       // nodes[1] 은 1에서 갈 수 있는 점들이 list형태로
        }

        for(int i=0 ; i<wires.length ; i++){
            int start= wires[i][0];
            int end=wires[i][1];
            nodes[start].add(end);   
            nodes[end].add(start); //양방향
        } //완성되어 있음

        for(int i=0 ; i<wires.length ; i++){ //완성되어있는데 한개씩 없애봄
            int start= wires[i][0];
            int end=wires[i][1];
            nodes[start].remove(  nodes[start].indexOf(end) );
            nodes[end].remove( nodes[end].indexOf(start));
            //여기서 이제 탐색하면 됨.
            int count = bfs();   //나뉘어진 전력망중 하나의 숫자.
            int nokoriCount=n-count;
            int dif= Math.abs( count-nokoriCount);
            min=Math.min(  min, dif   );


            nodes[start].add(end);   // 다시 붙임
            nodes[end].add(start);
        }
        return min;
    }

    public int bfs(){   //무조건 1에서 시작한다고 하자.. 트리형태니까 어디서 시작하든 상관없음
        //초기화
        for(int i=0 ; i<visit.length ; i++){
            visit[i]=false;
        }

        int count=0;
        Queue<Integer> que= new LinkedList<>();
        que.add(1);
        count++;
        visit[1]=true;
        while (!que.isEmpty()){
            int x= que.poll();
            for(int y : nodes[x]){
                if(visit[y]) continue;
                visit[y]=true;
                count++;
                que.add(y);
            }
        }
        return  count;
    }










//    static ArrayList<Integer>[] nodes=null;  //     시작점  4는  {5,6,7} 의 목적지를 가지고 있다.
//    static boolean[] visits=null;
//    static int[] childCounts= null;
//
//    public static int solution(int n, int[][] wires) {
//        nodes= new ArrayList[n+1];
//        visits=new boolean[n+1];
//        childCounts=new int[n+1];
//        for(int i= 1; i<nodes.length ; i++) {
//            nodes[i]= new ArrayList<Integer>();
//        }
//        for(int i=0 ; i<wires.length ; i++) {
//            ArrayList<Integer> list= nodes[   wires[i][0] ];
//            list.add(wires[i][1]);
//
//            // 2 -> 3 이면   3->2 도 해준다 , visits로 중복을 해결
//            ArrayList<Integer> list2= nodes[   wires[i][1] ];
//            list2.add(wires[i][0]);
//        }
//        dfs(1);
//
//        int min=Integer.MAX_VALUE;
//        for(int i=1; i<childCounts.length ; i++) {
//            childCounts[i]++;
//            int diff= Math.abs(n-childCounts[i]*2);
//            min=Math.min(min, diff);
//        }
//        return min;
//    }
//
//    public static void dfs(int num) {
//        visits[num]=true;
//        for( Integer desti : nodes[num]) {
//            if(visits[desti] ==true) continue;
//            childCounts[num]++;
//            dfs(desti);
//            childCounts[num]+=childCounts[desti];
//        }
//    }
}
