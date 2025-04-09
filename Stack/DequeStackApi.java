package Stack;
/**
 * 덱을 스택처럼 사용하기
 * 더 가볍고 빠른 스택이 필요할 때 
 * 기존 Stack 클래스는 내부적으로 Vector 기반이라 느림
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class DequeStackApi {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        // push (스택처럼 addFirst 또는 push)
        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println("현재 스택: " + stack); // [three, two, one]

        // peek (가장 위 요소 확인)
        System.out.println("peek(): " + stack.peek()); // three

        // pop (가장 위 요소 제거)
        System.out.println("pop(): " + stack.pop()); // three
        System.out.println("다시 peek(): " + stack.peek()); // two

        System.out.println("최종 스택 상태: " + stack); // [two, one]
    }
}
