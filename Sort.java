public class Sort {

    // 6 Sorting algorithms that sort Arrays of Comparables

    public static <T extends Comparable<T>> void insertionSort(T[] array, int low, int high, boolean reversed) {
        if (reversed == false) {
            for (int i = low+1; i <= high; i++) {
                T insertElem = array[i];
                int j = i;
                while (j > 0 && array[j-1].compareTo(insertElem) > 0) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = insertElem;
            }
        }
        else {
            for (int i = low+1; i <= high; i++) {
                T insertElem = array[i];
                int j = i;
                while (j > 0 && array[j-1].compareTo(insertElem) < 0) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = insertElem;
            }
        }
    }

    // < n-1 = < highIndex; < n = <= highIndex

    public static <T extends Comparable<T>> void selectionSort(T[] array, int low, int high, boolean reversed) {
        if (reversed == false) {
            for (int i = low; i < high; i++) {
                int min = i;
                for (int j = i+1; j <= high; j++) {
                    if (array[j].compareTo(array[min]) < 0) {
                        min = j;
                    }
                }
                swap(array, i, min);
            }
        }
        else {
            for (int i = low; i < high; i++) {
                int max = i;
                for (int j = i+1; j <= high; j++) {
                    if (array[j].compareTo(array[max]) > 0) {
                        max = j;
                    }
                }
                swap(array, i, max);
            }
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] array, int lowindex, int highindex, boolean reversed) {

    }
   
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

    // private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
    //     int i = low + 1;
    //     int j = high;
    //     int pivot = low;
    //     while (i <= j) {
    //         while (array[i].compareTo(array[pivot]) <= 0 && i <= j) {
    //             i++;
    //         }
    //         while (array[j].compareTo(array[pivot]) >= 0 && i <= j) {
    //             j--;
    //         }
    //         if (i < j) {
    //             swap(array, i, j);
    //         }
    //     }
    //     swap(array, j, pivot);
    //     return j;
    // }

    public static <T extends Comparable<T>> void optimizedQuickSort(T[] array, int lowindex, int highindex, boolean reversed) {
   
    }

    // 4 Sorting algorithms that sort Linked Lists of Comparables

    // for (int i = low+1; i <= high; i++) {
    //     T insertElem = array[i];
    //     int j = i;
    //     while (j > 0 && array[j-1].compareTo(insertElem) > 0) {
    //         array[j] = array[j-1];
    //         j--;
    //     }
    //    array[j] = insertElem;
    // }

    public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed) {
    //     LLNode cur1 = list.next();
    //     while (cur1 != null) {
    //         T insertElem = cur1.elem();
    //         LLNode cur2 = cur1;
    //         while (cur2 != head && cur2.parent().elem().compareTo(insertElem) > 0) {
    //             cur2 = cur2.parent();

    //         }
    //     }
        return null;
    }

    public static <T extends Comparable<T>> LLNode<T> selectionSortLL(LLNode<T> list, boolean reversed) {
        if (reversed == false) {
            LLNode cur1 = list;
            while (cur1.next() != null) {
                LLNode min = cur1;
                LLNode cur2 = cur1.next();
                while (cur2 != null) {
                    if (cur2.elem().compareTo(min.elem()) < 0) {
                        min = cur2;
                    }
                    cur2 = cur2.next();
                }
                swapNodes(cur1, min);
                cur1 = cur1.next();
            }
        }
        else {
            LLNode cur1 = list;
            while (cur1.next() != null) {
                LLNode max = cur1;
                LLNode cur2 = cur1.next();
                while (cur2 != null) {
                    if (cur2.elem().compareTo(max.elem()) > 0) {
                        max = cur2;
                    }
                    cur2 = cur2.next();
                }
                swapNodes(cur1, max);
                cur1 = cur1.next();
            }
        }
        return list;
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

    public static <T extends Comparable<T>> void swapNodes(LLNode<T> x, LLNode<T> y) {
        T temp = x.elem();
        x.setElem(y.elem());
        y.setElem(temp);
    }
}
