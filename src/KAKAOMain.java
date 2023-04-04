import java.util.*;

public class KAKAOMain {
    public static void main(String[] args) {
        String[] weights = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int[] picks = {1, 3, 2};
        int[] numbers={1,3,2,5,4,5,2,3};
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        String[][] plans={{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(solution(5,numbers));

    }

    public static  int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map=new HashMap<>(); //크기, 개수
        for(int i=0 ; i<tangerine.length ; i++){
            map.put( tangerine[i], map.getOrDefault(tangerine[i],0) +1 );
        }
        List<Integer> list=new ArrayList<>(map.values());
        list.sort((o1, o2) -> o2-o1 );
        int count=0;
        for(int i=0  ; i<list.size() ; i++){
            k-= list.get(i);
            count++;
            if(k<=0 ) break;
        }


        return count;
    }


}