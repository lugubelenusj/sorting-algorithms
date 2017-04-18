// import java.util.Random;
// import java.util.Arrays;

// public class Test {

//     public static Random generator = new Random();

//     public static void main(String[] args) {

//         long start, end;
//         double duration;

//         final int SIZE = 10;

//         // Test Array Algorithms
//         int[] sorted = new int[SIZE];
//         int[] invrse = new int[SIZE];
//         int[] random = new int[SIZE];

//         // Can we pass in a function into a function that runs it and calculates the time?
//         reset(sorted, invrse, random);
//         insertionSort(sorted, 0, SIZE-1, false);
//         insertionSort(invrse, 0, SIZE-1, false);
//         insertionSort(random, 0, SIZE-1, false);

//         reset(sorted, invrse, random);
//         selectionSort(sorted, 0, SIZE-1, false);
//         selectionSort(invrse, 0, SIZE-1, false);
//         selectionSort(random, 0, SIZE-1, false);

//         reset(sorted, invrse, random);
//         shellSort(sorted, 0, SIZE-1, false);
//         shellSort(invrse, 0, SIZE-1, false);
//         shellSort(random, 0, SIZE-1, false);

//         reset(sorted, invrse, random);
//         heapSort(sorted, 0, SIZE-1, false);
//         heapSort(invrse, 0, SIZE-1, false);
//         heapSort(random, 0, SIZE-1, false);

//         reset(sorted, invrse, random);
//         quickSort(sorted, 0, SIZE-1, false);
//         quickSort(invrse, 0, SIZE-1, false);
//         quickSort(random, 0, SIZE-1, false);

//         reset(sorted, invrse, random);
//         optimizedQuickSort(sorted, 0, SIZE-1, false);
//         optimizedQuickSort(invrse, 0, SIZE-1, false);
//         optimizedQuickSort(random, 0, SIZE-1, false);

//         // Test Linked List Algorithms

//         LLNode sortedLL = new LLNode(0);
//         LLNode invrseLL = new LLNode(0);
//         LLNode randomLL = new LLNode(0);

//         resetLL(sorted, invrse, random);
//         insertionSortLL(sorted, false);
//         insertionSortLL(invrse, false);
//         insertionSortLL(random, false);

//         resetLL(sorted, invrse, random);
//         selectionSortLL(sorted, false);
//         selectionSortLL(invrse, false);
//         selectionSortLL(random, false);

//         resetLL(sorted, invrse, random);
//         mergeSortLL(sorted, false);
//         mergeSortLL(invrse, false);
//         mergeSortLL(random, false);

//         resetLL(sorted, invrse, random);
//         quickSortLL(sorted, false);
//         quickSortLL(invrse, false);
//         quickSortLL(random, false);

//         resetLL(sorted, invrse, random);
//         insertionSort(sorted, false);
//         insertionSort(invrse, false);
//         insertionSort(random, false);

//     }

//     public static void reset(int[] sorted, int[] invrse, int[] random) {
//         for (int i = 0; i < SIZE; i++) {
//             sorted[i] = i;
//             invrse[i] = SIZE - i;
//             random[i] = generator.nextInt(50);
//         }
//     }

//     public static void resetLL(LLNode sortedLL, LLNode invrseLL, LLNode randomLL) {
//         LLNode sortedPointer = sortedLL;
//         LLNode invrsePointer = invrseLL;
//         LLNode randomPointer = randomLL;

//         for (int i = 0; i < SIZE; i++) {
//             sortedPointer.setNext(i);
//             invrsePointer.setNext(SIZE - i);
//             randomPointer.setNext(generator.nextInt(50));

//             sortedPointer = sortedPointer.next();
//             invrsePointer = invrsePointer.next();
//             randomPointer = randomPointer.next();
//         }

//         sortedLL = sortedLL.next();
//         invrseLL = invrseLL.next();
//         randomLL = randomLL.next();
//     }

// }