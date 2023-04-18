package programers.완전탐색;

public class 피로도 {
    boolean[] visit;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        rec_func(0,k,dungeons);
        return max;
    }


    public void rec_func(int depth, int nokori, int[][] dungeons) {   //남은 피로도
        max=Math.max(max,depth);  //실제로 전부 다 못 들어올수도 있음.
        if (depth == dungeons.length) {  //길이가 같다면 다 돈거
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] == false) {  //같은 던전은 안 돈다
                if (nokori >= dungeons[i][0]) {  //남은 피로도가 해당던전 최소피로도 이상일 때
                    visit[i] = true;
                    rec_func(depth + 1, nokori - dungeons[i][1], dungeons);
                    visit[i]=false;
                }
            }
        }

    }



//    boolean[] visit;
//    int max = 0;
//
//    public int solution(int k, int[][] dungeons) {
//        visit = new boolean[dungeons.length];
//        rec_func(0, k, dungeons);
//        return max;
//    }
//
//    public void rec_func(int depth, int k, int[][] dungeons) {
//        max = Math.max(max, depth);
//        for (int i = 0; i < dungeons.length; i++) {
//            if (!visit[i] && k>=dungeons[i][0]) {
//                visit[i] = true;
//                rec_func(depth + 1, k - dungeons[i][1], dungeons);  //dugeon 실제로 들어가서 count+1, 피로도감소
//                visit[i] = false;
//            }
//        }
//
//    }

}
