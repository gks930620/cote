package backjoon;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2160DFSBFS {
	// 함수에서 사용할 변수들
	static int[][] check; // 간선 연결상태
	static boolean[] checked; // 확인 여부
	static int n; // 정점개수
	static int m; // 간선개수
	static int start; // 시작정점
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		check = new int[1001][1001]; // 좌표를 그대로 받아들이기 위해 +1해서 선언
		checked = new boolean[1001]; // 초기값 False

		// 간선 연결상태 저장
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			check[x][y] = check[y][x] = 1;
		}

	  dfs(start); //dfs호출
	  
	  checked = new boolean[1001]; //확인상태 초기화
	  System.out.println(); //줄바꿈
	  bfs(); // bfs호출
	}
	public static void bfs() {
		Queue<Integer> queue= new LinkedList<>();
		queue.add(start);
		checked[start]=true;  //첫번째 노드는 체크했즘
		System.out.print(start + " ");
		while(!queue.isEmpty()) {
			int node=queue.poll();   //현재 노드.  이 노드에 연결된 간선을 방문해야지..
			for(int i=1; i<=n ; i++ ) {
				if(checked[i]==false && check[node][i]==1) { //아직 방문한거 아니면..  add하는순간이 방문하는거다
					queue.add(i);
					checked[i]=true;
					System.out.print(i +" ");
				}
			}
		}
	}
	public static void dfs(int start) {
		checked[start]=true;
		System.out.print(start +" " );
		for(int i=1; i<=n   ;i++) {
			if(check[start][i]==1 &&checked[i]==false) {
				dfs(i);
			}
		}
		
	}
	
}
