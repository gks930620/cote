package programers.힙;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0 ; i<scoville.length ; i++){
            pq.add(scoville[i]);
        }
        int count=0;
        while (!pq.isEmpty()  && pq.peek()<k){
            if(pq.size()==1) return -1;
            int s1=pq.poll();   //가장 맵지않은
            int s2=pq.poll();  //두번째로 맵지않은
            int newS= s1+2*s2;
            pq.add(newS);
            count++;
        }

        return count;
    }

    public int solution2(int[] scoville, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int count=0;
        for(int a  : scoville) {
            pq.add(a);
        }
        while(pq.peek() < k ) {
            if(pq.size()==1) return -1;
            int min= pq.poll();
            min= min+ pq.poll()*2;    // 여기서의 poll은 2번째로 매운 거.
            pq.add(min);
            count++;
        }
        return count;
    }
}
