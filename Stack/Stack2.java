package Stack;
/**
 * 제너릭 클래스 + 동적 + 배열 이용한 스택 구현
 * push, pop, peek, isEmpty, isFull, size, ensureCapacity, toString 메서드를 제공
 * 한 타입 <T>만 저장 가능
 * 형변환 필요 없음
 * 컴파일 타임에 오류를 잡아서 런타임 오류 없음
 */
import java.util.Arrays;

public class Stack2<T> {
    private T[] stackArray;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack2(int initialCapacity) {
        this.capacity = initialCapacity;
        this.stackArray = (T[]) new Object[initialCapacity];
        this.top = -1;
    }

    public void push(T value) {
        ensureCapacity();
        stackArray[++top] = value;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("스택이 비어 있습니다.");
        T value = stackArray[top];
        stackArray[top--] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("스택이 비어 있습니다.");
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    // 배열 동적으로 만들기
    private void ensureCapacity() {
        if (top == capacity - 1) {
            capacity *= 2;
            stackArray = Arrays.copyOf(stackArray, capacity);
        }
    }

    /**
     * @Override 자바에서 부모 클래스나 인터페이스에 정의된 메서드를 자식 클래스에서 "재정의"(오버라이드)할 때 붙이는 annotation
     * "내가 지금 부모로부터 상속받은 메서드를 새로 구현하는 거야!"라고 컴파일러에게 알려주는 역할
     * 오타가 있을 때 컴파일 에러 발생
     * Override 안하고 오타가 있으면 오류를 잡기 어려움
     * 
     * toString() : 자바의 최상위 클래스인 Object의 메서드
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

