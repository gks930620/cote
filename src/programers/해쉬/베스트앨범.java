package programers.해쉬;

import java.util.*;

public class 베스트앨범 {


    public static void main(String[] args) {
        String[] generes = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        List<Integer> solution = new 베스트앨범().solution(generes, plays);
        System.out.println(solution);
    }

    class Genere {
        public Genere(String genere, int play) {
            this.genere = genere;
            this.play = play;
        }

        String genere;
        int play;
    }

    class IndexPlay{
        public IndexPlay(int index, int play) {
            this.index = index;
            this.play = play;
        }

        int index;
        int play ;
    }

    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer= new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Genere> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Genere(entry.getKey(), entry.getValue()));
        }
        list.sort((o1, o2) -> o2.play - o1.play);   // 장르별 내림차순
        for (int i = 0; i < list.size(); i++) {   //장르 총 플레이가 높은 순대로 나온다.  100개 미만
            String genere = list.get(i).genere;
            List<IndexPlay> inGList= new ArrayList<>();
            for(int j=0 ; j<genres.length ; j++){  //10000개 미만
                if(genres[j].equals(genere)){
                    inGList.add( new IndexPlay(j, plays[j]) );
                }
            }
            if(inGList.size()>1){
                inGList.sort((o1, o2) ->  o1.play==o2.play ? o1.index-o2.index : o2.play -o1.play);
                answer.add(inGList.get(0).index);
                answer.add(inGList.get(1).index);
            }else{
                answer.add(inGList.get(0).index);
            }

        }

        return answer;
    }
}
