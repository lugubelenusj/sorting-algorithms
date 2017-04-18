import java.util.Random;

public class TestLinkedList {

    public static void main(String[] args) {
        
        long start, end;
        double duration;

        final int SIZE = 19;

        Random generator = new Random();
        LLNode head = new LLNode(generator.nextInt(50));
        LLNode current = head;

        start = System.currentTimeMillis();

        for (int j = 1; j < SIZE; j++) {
            current.setNext(new LLNode(generator.nextInt(50)));
            current = current.next();
        }

        System.out.print("Before: ");
        printList(head);
        head = Sort.mergeSortLL(head, true);
        System.out.print("After:  "); 
        printList(head);

        end = System.currentTimeMillis();

        duration = ((double) (end - start));
        System.out.println("duration: " + duration);
    }

    public static void printList(LLNode head) {
        LLNode current = head;
        while (current != null) {
            System.out.print(current.elem() + ", ");
            current = current.next();
        }
        System.out.println();
    }
}