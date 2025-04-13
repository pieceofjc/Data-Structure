package Queue;

public class Queue1 {
    // 필드 field
    int length;
    int front = 0;
    int rear = 0;

    Object[] queue;

    // 생성자 constructor
    public Queue1(int length) {
        this.length = length;
        this.queue = new Object[length];
    }

    // 데이터 삽입
    public void enqueue(Object data) {
        if (this.isFull()) {
            System.out.println("큐에 더이상 공간이 없습니다.");
            return;
        }
        this.queue[this.rear++ % this.length] = data;
    }

    // 데이터 삭제
    /**
     * 실제로 배열에서도 삭제하는 이유는?
     * null 처리되지 않으면 여전히 참조 중인 것으로 인식하여 쓰지도 않을 데이터가 계속 메모리에 남아 있게 됨
     * 작은 크기의 데이터는 상관 없을 수도 있지만
     * 큰 객체나 이미지 등이 들어간 경우 메모리 누수처럼 작용할 수 있음
     */
    public Object dequeue() {
        if (this.isEmpty()) return null;
        int index = this.front++ % this.length;
        Object data = this.queue[index];
        this.queue[index] = null;
        return data;
    }

    // peek : FO(front) 확인
    public Object peek() {
        if (this.isEmpty()) return null;
        return this.queue[this.front % this.length];
    }

    // 큐가 비었는지
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    // 큐가 꽉찼는지
    public boolean isFull() {
        return (this.rear - this.front) == this.length;
    }

    // print할 때 배열처럼 보이게
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        int size = this.rear - this.front;
        for (int i = 0; i < size; i++) {
            sb.append(queue[(this.front + i) % this.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1(3);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println(q);  // [A, B, C] (toString())

        System.out.println("dequeue: " + q.dequeue()); // A
        System.out.println(q);  // [B, C]

        q.enqueue("D");
        System.out.println("peek: " + q.peek());       // B
        System.out.println(q);  // [B, C, D]
    }
}
