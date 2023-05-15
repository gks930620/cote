package programers.그래프탐색;

import java.util.*;

public class 여행경로 { //실패  다시해보자.
    public static void main(String[] args) {
        String[][] tickets= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets2= {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[][] tickets3= {{"ICN", "SFO"},{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        List<String> solution = new 여행경로().solution(tickets3);
        System.out.println(solution);
    }
    Map<String, List<String>> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    public List<String> solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            map.put(start,map.getOrDefault(start,new LinkedList<>())     );
            map.get(start).add(end);
        }
        for(Map.Entry<String ,List<String >> entry : map.entrySet()){
            entry.getValue().sort(null);
        }
        bfs("ICN");


        return  answer;
    }

    public void bfs(String start) {
        PriorityQueue<String> que = new PriorityQueue<>();
        que.add(start);
        while (!que.isEmpty()){
            String x= que.poll();
            answer.add(x);
            List<String> ends = map.get(x);
            if(ends==null || ends.isEmpty()) continue;  // 최종목저지
            for(int i=0 ; i<ends.size()  ; i++){  //알파벳순으로 정렬되어있음

                que.add(ends.get(i));
                ends.remove(i);   // ICN=> ATL,SFO 중에서 ATL 갔다면 ATL 지우기  .  ICN에서 다시 출발해도 이번엔 ATL이 없음
                i--;
            }
        }
    }
}















