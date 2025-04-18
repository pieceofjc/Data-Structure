import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == '(') {
                    stack.push(S.charAt(j));  // 여는 괄호는 스택에 푸시
                } else {  // 닫는 괄호일 때
                    if (stack.empty()) {
                        stack.push('(');
                        break;  // 더 이상 진행하지 않고 종료
                    } else {
                        stack.pop();  // 여는 괄호가 있으면 스택에서 팝
                    }
                }
            }
            
            // 반복문 종료 후 스택이 비어 있으면 유효한 괄호
            if (!stack.empty()) {
                System.out.println("NO");
            } else if (stack.empty()) {
                System.out.println("YES");
            }
        }
    }
}
