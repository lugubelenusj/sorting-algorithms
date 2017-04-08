public class Sort {

    // 6 Sorting algorithms that sort Arrays of Comparables

    public static <T extends Comparable<T>> void insertionSort(T[] array, int lowIndex, int highIndex, boolean reversed) {
        for (int i = lowIndex+1; i <= highIndex; i++) {
            for (int j = i; j > lowIndex; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    swap(array, j, j-1);
                }
            }
        }
    }

    // < n-1 = < highIndex; < n = <= highIndex

    public static <T extends Comparable<T>> void selectionSort(T[] array, int lowIndex, int highIndex, boolean reversed) {
        for (int i = lowIndex; i < highIndex; i++) {
            int smallIndex = i;
            for (int j = i+1; j <= highIndex; j++) {
                if (array[j].compareTo(array[smallIndex]) < 0) {
                    smallIndex = j;
                }
            }
            swap(array, i, smallIndex);
        }
    }

    // public static <T extends Comparable<T>> void shellSort(T[] array, int lowindex, int highindex, boolean reversed) {
    //     for (int increment = (highIndex+1)/2; increment > lowIndex; increment = increment/2) {
    //         for (int offset = 0; offset < increment; offset++) {

    //         }
    //     }
    // }
   
    public static <T extends Comparable<T>> void heapSort(T[] array, int lowindex, int highindex, boolean reversed) {
    
    }

    // public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean reversed) {
    //      if (low < high) {
    //          int mid = partition(array, low, high);
    //          quickSort(array, low, mid, false);
    //          quickSort(array, mid+1, high, false);
    //      }
    // }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean reversed) {
        int i = low;
        int j = high;
        T pivot = array[low + (high-low)/2];

        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j, false);
        }
        if (i < high) {
            quickSort(array, i, high, false);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        int i = low + 1;
        int j = high;
        int pivot = low;
        while (i <= j) {
            while (array[i].compareTo(array[pivot]) <= 0 && i <= j) {
                i++;
            }
            while (array[j].compareTo(array[pivot]) >= 0 && i <= j) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, j, pivot);
        return j;
    }

    public static <T extends Comparable<T>> void optimizedQuickSort(T[] array, int lowindex, int highindex, boolean reversed) {
   
    }

    // 4 Sorting algorithms that sort Linked Lists of Comparables

    public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed) {

        return null;    
    }

    public static <T extends Comparable<T>> LLNode<T> selectionSortLL(LLNode<T> list, boolean reversed) {

        return null;
    }

    public static <T extends Comparable<T>> LLNode<T> mergeSortLL(LLNode<T> list, boolean reversed) {    

        return null;
    }

    public static <T extends Comparable<T>> LLNode<T> quickSortLL(LLNode<T> list, boolean reversed) {

        return null;
    }

    // 1 Sorting algorithm that sorts an Array of ints
   
    public static void bucketSort(int[] array, int lowindex, int highindex, boolean reversed) {

    }

    // 1 Sorting algorithm that sorts an Array of Strings

    public static void radixSort(String[] array, int lowindex, int highindex, boolean reversed) {
            
    }
    
    public static <T extends Comparable<T>> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
