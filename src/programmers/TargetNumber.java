package programmers;

public class TargetNumber {
	public static void main(String[] args) {
		int[] arr= {4,1,1};
		System.out.println(solution(arr, 4));
	}
	// dfs 진행하면서 +,- 다해보기
	//detph는 반드시 최고일 것
	//sum=target이면  count++
	//난 완전 탐색으로 생각했지만 순서는 상관이없지.. 순서생각해서 for을 막 쓰는게 아니지.
	//한번만 순회하면 되지
	static int count;
	public static int solution(int[] numbers, int target) {
		dfs(numbers, target,0,0);
		return count;
	}
	
	
	public static void  dfs(int[] numbers, int target,int depth, int sum) {
		if(depth==numbers.length) {
			if(target==sum) count++;
			return;
		}
		//dfs를 2번 하는데 어쩔때는 +, 어쩔때는 -
		dfs(numbers, target, depth+1, sum+numbers[depth]);
		dfs(numbers, target, depth+1, sum-numbers[depth]);
	}
}
