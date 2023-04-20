package programers.level2;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        char A = 65;
        char Z = 90;
        int solution = new 뉴스클러스터링().solution("E=M*C^2", "e=m*c^2");
        System.out.println(solution);
    }

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        initListUsingStrOnlyAlphabetElements(list1, str1);
        initListUsingStrOnlyAlphabetElements(list2, str2);

        //list1,2에는 대문자로만 구성된 문자들
        List<String> cha = new ArrayList<>();
        List<String> hap = new ArrayList<>();
        List<String> kyo = new ArrayList<>();


        kyo.addAll(list1);
        kyo.retainAll(list2);
        cha.addAll(list1);
        cha.removeAll(list2);
        hap.addAll(cha);
        hap.addAll(list2);
        double kyoCount=kyo.size();
        double hapCount=hap.size();
        double jakad =  hapCount==0 ? 1 :  kyoCount/hapCount ;
        int answer= (int)(jakad*65536);
        return answer;
    }

    public void initListUsingStrOnlyAlphabetElements(List<String> list, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String ele = str.substring(i, i + 2);
            if (isConfiguredWithAlphabet(ele)) {
                list.add(ele);
            }
        }
    }

    public boolean isConfiguredWithAlphabet(String ele) {
        char ch1 = ele.charAt(0);
        char ch2 = ele.charAt(1);
        if (ch1 >= 65 && ch1 <= 90 && ch2 >= 65 && ch2 <= 90) {
            return true;
        } else {
            return false;
        }
    }

}
