package programers.해쉬;

import  java.util.*;
public class 완주하지못한선수 {


    public static String solution(String[] participant, String[] completion) {
        Map<String,Integer> map=new HashMap<>();  //참가자, 동명이인수
        for(int i=0 ; i<participant.length ; i++){
            map.put( participant[i],  map.getOrDefault(participant[i],0)+1  );
        }
        for(int i=0 ; i<completion.length ; i++){
            map.put(completion[i],   map.get(completion[i])-1);
        }

        for(String key : map.keySet()){
            if(map.get(key)==1){
                return  key;
            }
        }

        return null;
    }




    public static String solution2(String[] participant, String[] completion) {
        Map<String,Integer> map= new HashMap<String, Integer>();
        for(int i=0 ; i<participant.length ; i++) { // 참가자 map에 넣기
            int nameCount=map.getOrDefault(participant[i], 0);
            map.put(participant[i],nameCount+1);
        }

        //completion 반복하면서 map에서 -1해야겠네.
        for(int i=0 ; i<completion.length ; i++) {
            map.put(completion[i],  map.get(completion[i])-1    ) ;
        }

        // map에서 값이 1인 것의 key 값이  완주하지못한자.
        for( Map.Entry<String, Integer> entry :   map.entrySet() ) {
            if(entry.getValue() ==1) return entry.getKey();
        }


        return null;
    }
}
