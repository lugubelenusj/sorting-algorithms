import java.util.Random;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
        
        long start, end;
        double duration;

        final int SIZE = 2000000;
        Integer[] array = new Integer[SIZE];
        // int[] array = new int[SIZE];

        Random generator = new Random();

        start = System.currentTimeMillis();

        for (int j = 0; j < SIZE; j++) {
            array[j] = generator.nextInt(50);
        }

        System.out.println("Before: " + Arrays.toString(array));
        Sort.optimizedQuickSort(array, 0, SIZE-1, false);
        // Sort.shellSort(array, 3, 17, false);
        System.out.println("After : " + Arrays.toString(array));

        end = System.currentTimeMillis();

        duration = ((double) (end - start));
        System.out.println("duration: " + duration);
    }
}