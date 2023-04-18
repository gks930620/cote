package programers.힙;

import java.util.PriorityQueue;

public class 이중우선순위큐 {



    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o2 - o1);  //큰게 맨 앞으로  내림차순
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); //작은게 맨 앞으로   오름차순
        for(int i=0 ; i<operations.length ; i++){
            String operation=operations[i];
            if(operation.startsWith("I")){ //삽입
                String[] s = operation.split(" ");
                int num = Integer.parseInt(s[1]);
                pqMax.add(num);
                pqMin.add(num);   //둘다 넣자.
            }else  if(operation.equals("D 1")){ //최대값 삭제
                if(pqMax.isEmpty()) continue;
                int maxPoll = pqMax.poll();   //pqMax 맨 앞 삭제
                pqMin.remove(maxPoll);         // pqMin에서 그 값 삭제
            }else {  //최소값 삭제
                if(pqMax.isEmpty()) continue;
                int minPoll = pqMin.poll();
                pqMax.remove(minPoll);
            }
        }
        int[] answer= {pqMax.peek(), pqMin.peek() };

        return  answer;
    }


    public int[] solution2(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("I")) {
                int a = Integer.parseInt(operations[i].split(" ")[1]);
                pqMax.add(a);
                pqMin.add(a);
            }
            if (operations[i].equals("D 1")) {
                if (!pqMax.isEmpty()) {
                    int max = pqMax.poll();
                    pqMin.remove(max);
                }
            }

            if (operations[i].equals("D -1")) {
                if (!pqMax.isEmpty()) {
                    int min = pqMin.poll();
                    pqMax.remove(min);
                }
            }
        }
        int[] arr=new int[2];
        if(pqMax.isEmpty()) {
            return arr;
        }
        arr[0]= pqMax.poll();
        arr[1]=pqMin.poll();

        return arr;
    }
}
