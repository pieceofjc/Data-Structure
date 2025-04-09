package Stack;
/**
 * Object 배열을 이용한 스택 구현
 * 고정 배열이지만 top을 이용하여 고정 배열을 동적 배열처럼 사용하여 스택을 구현함
 * push, pop, peek, isEmpty, isFull, size 메서드를 제공
 * 스택은 후입선출(LIFO) 원칙을 따름
 * 
 * Object 배열로 만들었을 때, Object가 최상위 클래스이기 때문에
 * 여러 타입 저장 가능
 * 형변환 필요
 * 컴파일타임 오류는 없어도 런타임 오류 있을 가능성 있음
 */
public class Stack {
    private Object[] stackArray; // 배열
    private int top; // top 인덱스
    private int capacity; // 최대 스택 배열 크기

    // 생성자
    public Stack(int size) {
        stackArray = new Object[size];
        capacity = size;
        top = -1;
    }

    // 마지막 데이터 추가
    // 반환값이 없음
    public void push(Object value) {
        if (isFull()) {
            System.out.println("isFull() : 스택이 가득 참");
            return;
        }
        stackArray[++top] = value; // top은 현재 위치가 됨
    }

    // 마지막 데이터 삭제
    public Object pop() {
        if (isEmpty()) {
            System.out.println("isEmpty() : 스택이 비어 있음");
            return -1;
        }
        return stackArray[top--]; // 현재 위치인 top을 반환하고 새로운 top은 top - 1이 됨
    }

    // 마지막 데이터 확인
    public Object peek() {
        if (isEmpty()) {
            System.out.println("isEmpty() : 스택이 비어 있음");
            return -1;
        }
        return stackArray[top];
    }

    // 스택이 비어 있는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택이 가득 찼는지 확인
    public boolean isFull() {
        return top == capacity - 1; // 스택의 최대 크기 - 1과 같으면 가득 찼음
    }

    // 추가적인 메서드 : 크기 확인
    public int size() {
        return top + 1; // top은 인덱스 이므로 크기는 top + 1
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push("hello");
        stack.push(false);

        System.out.println("top 데이터 : " + stack.peek());
        System.out.println("스택 크기: " + stack.size());

        String poped = (String) stack.pop(); // 컴파일은 되는데 실행했을 때 런타임 오류 발생 가능
        System.out.println("pop을 한 후 top 데이터: " + stack.peek());
    }
}