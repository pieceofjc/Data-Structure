package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10828
public class Stack10828 {
    /**
     * static이 붙으면 클래스 변수로
     * 모든 객체에서 공유된다
     * static이 없으면 각 객체마다 별도의 변수가 된다
     */
	static int[] stack = new int[10001]; // 주어질 명령의 최대 수 이상으로 초기화
	static int size; // 0으로 자동 초기화
	public static void main(String[] args) throws IOException {
        // BufferedReader.readLine으로 한 줄 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
        // StringBuilder : String을 효율적으로 다룰 수 있는 클래스
        StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			switch (S) {
			case "push" :
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				sb.append(pop()).append("\n");
				break;
			case "size" :
				sb.append(size()).append("\n");
				break;
			case "empty" :
				sb.append(empty()).append("\n");
				break;
			case "top" :
				sb.append(top()).append("\n");
				break;
			}
		}
        
        // 반복문이 끝난 후 모든 출력값을 프린트함
		System.out.println(sb);
	}
	
    // 메소드
    
	public static void push(int data) {
		stack[size++] = data;
	}
	
    // 삭제
	public static int pop() {
		if(size == 0) return -1;
		else {
			int popData = stack[size - 1];
            stack[size - 1] = 0;
			size--;
			return popData;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) return 1;
		else return 0;
	}

	// 스택 가장 위(LI) 정수
	public static int top() {
		if(empty() == 1) return -1; // 스택에 들어있는 정수가 없는 경우 -1을 출력한다
		return stack[size - 1];
	}

}