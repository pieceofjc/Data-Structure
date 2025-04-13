package Queue;
/**
 * 연결리스트 큐 구현하기
 * 연결리스트는 동적 배열로 isFull은 필요 없고, isEmpty만 확인하면 됨
 */

public class Queue2 {

    // 내부 노드 클래스 (정적 클래스)
    private static class QueueNode {
        int value;
        QueueNode next;

        public QueueNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // 큐의 필드: head = front(삭제 위치), tail = rear(삽입 위치)
    private QueueNode head; // front
    private QueueNode tail; // rear

    // 생성자
    public Queue2() {
        this.head = null;
        this.tail = null;
    }

    // 데이터 추가
    public void push(int data) {
        QueueNode newNode = new QueueNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 데이터 제거
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        int value = head.value;
        head = head.next;
        if (head == null) tail = null; // 마지막 요소 제거 시 tail도 null로
        return value;
    }

    // front 값 확인
    public Integer peek() {
        if (isEmpty()) return null;
        return head.value;
    }

    // 큐 비어있는지 확인
    public boolean isEmpty() {
        return head == null;
    }

    // 큐 크기 반환
    public int size() {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 큐 내용을 문자열로
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        QueueNode current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // 테스트 main
    public static void main(String[] args) {
        Queue2 queue = new Queue2();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Queue: " + queue); // [10, 20, 30]
        System.out.println("Peek: " + queue.peek()); // 10
        System.out.println("Pop: " + queue.pop()); // 10
        System.out.println("Queue after pop: " + queue); // [20, 30]
        System.out.println("Size: " + queue.size()); // 2
    }
}

