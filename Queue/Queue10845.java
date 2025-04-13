package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue10845 {
    
    static int[] queue = new int[10001];
    static int front, back;
    static int size = 10001;

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
			case "front" :
				sb.append(front()).append("\n");
				break;
            case "back" :
				sb.append(back()).append("\n");
				break;
			}
		}

        // 반복문이 끝난 후 모든 출력값을 프린트함
		System.out.println(sb);
        
    }

    // 메소드

    public static void push(int data) {
        queue[back++] = data; 
    }

    public static int pop() {
        if(empty() == 1) return -1;
        return queue[front++];

    }

    public static int size() {
        return back - front;
    }

    public static int empty() {
        if(size() == 0) return 1;
        else return 0;
    }

    public static int front() {
        return size() != 0 ? queue[front] : -1;
    }

    public static int back() {
        return size() != 0 ? queue[back-1] : -1;
    }
}
