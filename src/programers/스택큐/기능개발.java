package programers.스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class 기능개발 {

    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queP = new LinkedList<>();
        Queue<Integer> queS = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queP.add(progresses[i]);
            queS.add(speeds[i]);
        }
        int days = 0;  //며칠 지났는지

        while (!queP.isEmpty()) {  //빌 때까지
            int pro = queP.peek();
            int speed = queS.peek();
            int count=0;
            //현재 일이 완료가 덜 됬다면, 하루하루 일 더함
            while (pro + speed * days < 100) {
                days++;
            }

            //여기까지 했으면 일단 첫번째 작업은 100이 넘었음  그럼 이제 que를 계속 뒤져보자
            while (!queP.isEmpty() &&  queP.peek() + queS.peek()*days >=100){  //처음은 넘었으니까 무조건 실행될거임.  다음것도 넘었는지 조사함
                count++;
                queP.poll();
                queS.poll();
            }
            answer.add(count);
        }

        return answer;
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> queP = new LinkedBlockingDeque<Integer>();
        Queue<Integer> queS = new LinkedBlockingDeque<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int p : progresses)
            queP.add(p);
        for (int s : speeds)
            queS.add(s);
        int days = 0;
        while (!queP.isEmpty()) { // que에서 다 빠져나올때까지
            int peek = queP.peek() + days * queS.peek();
            while (peek < 100) { // 몇일이 지났는지 계산. 첫번째 과정이 100이 될 때 까지
                days++;
                peek += queS.peek();
            }
            queP.poll(); // 제거
            queS.poll();
            int count = 1; // 일단 1개는 무조건 나오지.

            // 위 과정에서 100이 넘은 것들이 몇개있는지 검사 . days만큼 더하면 되지않을까?

            while (!queP.isEmpty() && queP.peek() + days * queS.peek() >= 100) {
                count++;
                queP.poll();
                queS.poll();

            }
            list.add(count);
            System.out.println(count);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

}
