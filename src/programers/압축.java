package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 압축 {
    public static void main(String[] args) {
        int[] answer = new 압축().solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println(Arrays.toString(answer));
    }

    List<String> diction = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    public int[] solution(String msg) {
        for (char i = 65; i <= 90; i++) {
            diction.add(String.valueOf(i));
        }
        while (msg.length() != 0) {
            String cur = msg.substring(0, 1);
            int length = 1;
            while (diction.contains(cur)) {    //사전에 없을 때 까지 조사.    KAO  사전에 없지..
                length++;
                if (msg.length() >= length) {
                    cur = msg.substring(0, length);
                }else {  //length가 더 커짐..
                    cur=msg+"a";   // 어차피 msg가 길이가 0이 돼서 더 진행안되는데,  밑의 코드가 정확히 작동하도록 cur에 "a"를 추가함
                }
            }
            diction.add(cur);
            String removeStr = cur.substring(0, cur.length() - 1);
            msg = msg.replaceFirst(removeStr, "");
            answer.add(diction.indexOf(removeStr) + 1);
        }
        int[] answerArray=new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answerArray[i]=answer.get(i);
        }
        return answerArray;
    }
}
