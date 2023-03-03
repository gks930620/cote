import java.util.*;

public class KAKAOMain {
    public static void main(String[] args) {
        int[][] queries = {{3, 1}, {2, 3}, {3, 9}};
        System.out.println(Arrays.toString(solution(queries)));
    }

    public String bean(int generation, int idx) {
        if(generation == 1) return "Rr";

        String parent = bean(generation-1, (idx-1)/4+1);
        if(parent.equals("RR") || parent.equals("rr")) return parent;
        int group = (idx-1) % 4;
        switch(group) {
            case 0 : return "RR";
            case 1 : return "Rr";
            case 2 : return "Rr";
            default : return "rr";
        }
    }

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i = 0; i < queries.length; i++) {
            String ans = bean(queries[i][0], queries[i][1]);
            answer[i] = ans;
        }

        return answer;
    }


}

