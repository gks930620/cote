package programers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        String[] words= {"hot", "dot", "dog", "lot", "log"};
        int solution = new 단어변환().solution("hit", "cog", words);
        System.out.println(solution);
    }

    int[] dist;
    boolean[] visit;
    class Info{
        String word;
        int index;

        public Info(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
    public int solution(String begin, String target, String[] words) {
        //begin을 words[0]d에..
        String[] newWords= new String[words.length+1];
        newWords[0]=begin;
        for(int i=1 ; i<newWords.length ; i++){
            newWords[i]=words[i-1];
        }
        words=newWords ;
        //word[0]에는 begin이 있고 그 뒤로 원래 words가 있다.

        dist=new int[words.length];
        visit=new boolean[words.length];


        Queue<Info> queue=new LinkedList<>();
        queue.add(new Info(begin,0));
        visit[0]=true;
        while (!queue.isEmpty()){
            Info curInfo= queue.poll();
            String cur= curInfo.word;
            int curIndex= curInfo.index;
            for(int i=0 ; i<words.length ; i++){
                if( visit[i]==false &&canChange(cur, words[i])){
                    queue.add(new Info(words[i],i));
                    dist[i]=dist[curIndex]+1;
                    visit[i]=true;
                }
            }
        }

        //dist값
        int index=-1;
        for(int i=0 ; i<words.length ; i++){
            if(words[i].equals(target)){
                index=i;
            }
        }
        if(index==-1) return  0;
        return dist[index];
    }

    public boolean canChange(String cur, String next){
        int difCount=0;
        for(int i=0 ; i<cur.length() ; i++){
            char curCh= cur.charAt(i);
            char nextCh= next.charAt(i);
            if(curCh!=nextCh) difCount++;
        }
        return difCount==1 ? true : false;
    }


}
