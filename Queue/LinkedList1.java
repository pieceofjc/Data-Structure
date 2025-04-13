package Queue;

public class LinkedList1{

    // 내부 Node 클래스
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head; // 리스트의 시작점
    private Node tail; // 리스트의 끝 (옵션)

    // 생성자
    public LinkedList1() {
        head = tail = null;
    }

    // 끝에 노드 추가
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 특정 값 삭제 (첫 번째 만나는 값 기준)
    public void remove(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next == null) tail = current;
        }
    }

    // 리스트가 비어있는지 확인
    public boolean isEmpty() {
        return head == null;
    }

    // 리스트의 크기
    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // 리스트를 문자열로 출력
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // 테스트
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list); // [1, 2, 3]

        list.remove(2);
        System.out.println(list); // [1, 3]

        System.out.println("Size: " + list.size()); // 2
        System.out.println("Is empty: " + list.isEmpty()); // false

        list.remove(1);
        list.remove(3);
        System.out.println(list); // []
        System.out.println("Is empty: " + list.isEmpty()); // true
    }
}
