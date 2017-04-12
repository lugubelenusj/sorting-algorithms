import java.util.Random;

public class TestLinkedList {

    public static void main(String[] args) {
        
        long start, end;
        double duration;

        final int NUMITER = 1;
        final int SIZE = 20;

        Random generator = new Random();
        LLNode head = new LLNode(generator.nextInt(50));
        LLNode current = head;

        start = System.currentTimeMillis();
        for (int i = 0; i < NUMITER; i++) {
            for (int j = 0; j < SIZE; j++) {
                current.setNext(new LLNode(generator.nextInt(50)));
                current = current.next();
            }
            System.out.print("Before: ");
            printList(head);
            Sort.selectionSortLL(head, true);
            System.out.print("After:  "); 
            printList(head);
        }
        end = System.currentTimeMillis();

        duration = ((double) (end - start)) / NUMITER;
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