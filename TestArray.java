import java.util.Random;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
        
        long start, end;
        double duration;

        final int NUMITER = 1;
        final int SIZE = 20;
        Integer[] array = new Integer[SIZE];

        Random generator = new Random();

        start = System.currentTimeMillis();
        for (int i = 0; i < NUMITER; i++) {
            for (int j = 0; j < SIZE; j++) {
                array[j] = generator.nextInt(50);
            }
            System.out.println("Before: " + Arrays.toString(array));
            // (2, 10) (0, SIZE -1)
            Sort.quickSort(array, 0, SIZE - 1, true);
            System.out.println("After : " + Arrays.toString(array));
        }
        end = System.currentTimeMillis();

        duration = ((double) (end - start)) / NUMITER;
        System.out.println("duration: " + duration);
    }
}