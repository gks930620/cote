package programers.level2;

public class 점찍기 {

    public static void main(String[] args) {
        long solution = new 점찍기().solution(1, 5);
        System.out.println(solution);
    }
    public long solution(int k, int d) {
        long answer = 0;

        for (long i = 0; i <= d/k; i++) {
            long x = i * k;
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2)) / k;

            answer += y + 1; // 0도 포함해주어야 하므로 +1
        }
        return answer;
    }

}
