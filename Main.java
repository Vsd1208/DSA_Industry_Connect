import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Main {

    // Finds nth node from end using two-pointer gap method
    private static void nthFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            System.out.println("Invalid input");
            return;
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                System.out.println("n is greater than list length");
                return;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = sc.nextInt();
        nthFromEnd(head, n);
    }
}