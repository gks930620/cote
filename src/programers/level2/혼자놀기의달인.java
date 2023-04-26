package programers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 혼자놀기의달인 {
    public static void main(String[] args) {
        int[] cars = {8, 6, 3, 7, 2, 5, 1, 4};
        new 혼자놀기의달인().solution(cars);
    }

    //런타임에러나네.. 다시 생각해보자....  문제 어렵지않다.. 논리만 좀 쉽게 객체지향적 설계로다가.
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (visit[i] == true) {  //그룹에서 선택한거면 다음값 확인
                continue;
            }

            //하나의 그룹 반복
            int count = 0;
            int next = i;
            while (visit[next] == false) {
                visit[next] = true;
                next = cards[next] - 1;     //temp : i+1번째 카드의 값  =>  다음에 열어야 할 곳은 cards[temp-1]
                count++;
            }
            list.add(count);
        }
        if(list.size() >=2){
            list.sort((o1, o2) -> o2 - o1);
            return list.get(0) * list.get(1);
        }
        return 0;
    }


}
