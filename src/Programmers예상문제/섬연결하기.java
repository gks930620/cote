package Programmers예상문제;

import java.util.Arrays;

public class 섬연결하기 {

    //섬 연결하기
    //연습해보자.  해보니까 원리 자체는 그렇게 어렵지 않네
    public  static int solution(int n, int[][] costs) {
        int[] parent=new int[n]; //섬의 개수만큼
        int total=0; //가중치 합

        for (int i = 0; i < parent.length; i++) {  //초기 부모는 다 자기자신..
            parent[i] = i;
        }
        Arrays.sort(costs,(o1, o2)-> o1[2]-o2[2]);   //비용을 기준으로 정렬

        //위에서 언급한대로 간선을 선택하면 해당 간선의 정점 두 개를 Union으로 합치고,
        // 사이클 여부를 판단할 때는 두 정점의 parent가 일치하는지를 find 함수를 통해 찾으면 된다.
        for (int i = 0; i < costs.length; i++) {
            int from=costs[i][0];
            int to=costs[i][1];
            int cost=costs[i][2];
            if (find(parent, from) != find(parent, to)  ){   // 간선에 있는 곳이 부모가 같지않다면....   사이클 x
                total += cost;
                union(parent, from, to);   //둘이 합침
            }
        }
        return 0;
    }

    public static int find(int[] parent, int i) {  //어떻게든 부모를 찾아주는 함수.
        //자기 자신을 가리키니 부모가 맞다.
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);
        //아묻따   작은놈이 부모가..
        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }


}
