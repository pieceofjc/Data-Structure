package Stack;
/**
 * java.util.Stack
 * 내부적으로 배열을 사용하지만, 필요할 때마다 자동으로 용량을 늘리는 기능이 있음
 * 배열은 toString()이 없어서 출력이 안됨, Stack은 toString() 오버라이딩 돼 있어서 예쁘게 나옴
 */
import java.util.Stack;

public class StackAPI {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Stack: " + stack);

        // Peek the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Display the stack after popping
        System.out.println("Stack after popping: " + stack);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
