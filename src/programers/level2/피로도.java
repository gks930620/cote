package programers.level2;

public class 피로도 {
    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = new 피로도().solution(80, dungeons);
        System.out.println(solution);
    }

    boolean[] visit;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        rec_func(0, k, dungeons);
        return max;
    }

    public void rec_func(int depth, int k, int[][] dungeons) {  // count는 실제로 들어간 개수, depth는 깊이
        max = Math.max(max, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k>=dungeons[i][0]) {
                    visit[i] = true;
                    rec_func(depth + 1, k - dungeons[i][1], dungeons);  //dugeon 실제로 들어가서 count+1, 피로도감소
                    visit[i] = false;
            }
        }

    }
}
