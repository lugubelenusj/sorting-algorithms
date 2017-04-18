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

    public static <T extends Comparable<T>> void shellSort(T[] array, int low, int high, boolean reversed) {
        int n = high - low + 1;
        for (int increment = n/2; increment > 0; increment = increment/2) {
            for (int offset = 0; offset < increment; offset++) {
                shellInsertionSort(array, n, offset, increment, reversed, low);
            }
        }
    }

    private static <T extends Comparable<T>> void shellInsertionSort(T[] array, int n, int offset, int increment, boolean reversed, int low) {
        if (reversed == false) {
            for (int i = offset+increment; i < n+low; i = i+increment) {
                T insertElem = array[i];
                int j;
                for (j = i-increment; j>=low && array[j].compareTo(insertElem) > 0; j = j-increment) {
                    array[j+increment] = array[j];
                }
                array[j+increment] = insertElem;
            }
        }
        else {
            for (int i = offset+increment; i < n+low; i = i+increment) {
                T insertElem = array[i];
                int j;
                for (j = i-increment; j>=low && array[j].compareTo(insertElem) < 0; j = j-increment) {
                    array[j+increment] = array[j];
                }
                array[j+increment] = insertElem;
            }
        }
    }
   
    public static <T extends Comparable<T>> void heapSort(T[] array, int low, int high, boolean reversed) {
    
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean reversed) {
        if (low < high) {
            int mid = partition(array, low, high, reversed);
            quickSort(array, low, mid, reversed);
            quickSort(array, mid+1, high, reversed);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, boolean reversed) {
        int i = low - 1;
        int j = high + 1;
        int pivot = low;
        if (reversed == false) {
            while (i < j) {
                for (i++; array[i].compareTo(array[pivot]) < 0; i++);
                for (j--; array[j].compareTo(array[pivot]) > 0; j--);
                if (i < j) {
                    swap(array, i, j);
                }
            }
        }
        else {
            while (i < j) {
                for (i++; array[i].compareTo(array[pivot]) > 0; i++);
                for (j--; array[j].compareTo(array[pivot]) < 0; j--);
                if (i < j) {
                    swap(array, i, j);
                }
            }
        }
        return j;
    }

    public static <T extends Comparable<T>> void optimizedQuickSort(T[] array, int low, int high, boolean reversed) {
        if (array.length < 20) {
            shellSort(array, low, high, reversed);
        }
        else if (low < high) {
            int mid = partition(array, low, high, reversed);
            quickSort(array, low, mid, reversed);
            quickSort(array, mid+1, high, reversed);
        }
    }

    // 4 Sorting algorithms that sort Linked Lists of Comparables

    public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> node, boolean reversed) {
        if (reversed == false) {
            if (node.next() == null) {
                return node;
            }
            else {
                LLNode head = insertionSortLL(node.next(), reversed);
                LLNode<T> current = head;
                while (current.next() != null) {
                    if (node.elem().compareTo(current.elem()) < 0) {
                        swapNodes(node, current);
                    }
                    current = current.next();
                }
                if (current.elem().compareTo(node.elem()) > 0) {
                    swapNodes(node, current);
                }
                node.setNext(null);
                current.setNext(node);
                return head;
            }
        }
        else {
            if (node.next() == null) {
                return node;
            }
            else {
                LLNode head = insertionSortLL(node.next(), reversed);
                LLNode<T> current = head;
                while (current.next() != null) {
                    if (node.elem().compareTo(current.elem()) > 0) {
                        swapNodes(node, current);
                    }
                    current = current.next();
                }
                if (current.elem().compareTo(node.elem()) < 0) {
                    swapNodes(node, current);
                }
                node.setNext(null);
                current.setNext(node);
                return head;
            }
        }
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

    public static <T extends Comparable<T>> LLNode<T> mergeSortLL(LLNode<T> node, boolean reversed) {
        if (reversed == false) {    
            if (node.next() == null) {
                return node;
            }
            else if (node.next().next() == null) {
                if (node.elem().compareTo(node.next().elem()) > 0) {
                    swapNodes(node, node.next());
                }
                return node;
            }
            else {
                LLNode<T> LHead = node;
                LLNode<T> mid = getMid(node);
                LLNode<T> RHead = mid.next();
                mid.setNext(null);

                LHead = mergeSortLL(LHead, reversed);
                RHead = mergeSortLL(RHead, reversed);

                LLNode<T> LCur = LHead;
                LLNode<T> RCur = RHead;

                while (LCur != null) {
                    while (RCur != null) {
                        if (LCur.elem().compareTo(RCur.elem()) > 0) {
                            swapNodes(LCur, RCur);
                        }
                        RCur = RCur.next();
                    }
                    RCur = RHead;
                    LCur = LCur.next();
                }
                LLNode<T> sortedLeft = insertionSortLL(LHead, reversed);
                LLNode<T> sortedRight = insertionSortLL(RHead, reversed);
                return combine(sortedLeft, sortedRight);
            }
        }
        else {
            if (node.next() == null) {
                return node;
            }
            else if (node.next().next() == null) {
                if (node.elem().compareTo(node.next().elem()) < 0) {
                    swapNodes(node, node.next());
                }
                return node;
            }
            else {
                LLNode<T> LHead = node;
                LLNode<T> mid = getMid(node);
                LLNode<T> RHead = mid.next();
                mid.setNext(null);

                LHead = mergeSortLL(LHead, reversed);
                RHead = mergeSortLL(RHead, reversed);

                LLNode<T> LCur = LHead;
                LLNode<T> RCur = RHead;

                while (LCur != null) {
                    while (RCur != null) {
                        if (LCur.elem().compareTo(RCur.elem()) < 0) {
                            swapNodes(LCur, RCur);
                        }
                        RCur = RCur.next();
                    }
                    RCur = RHead;
                    LCur = LCur.next();
                }
                LLNode<T> sortedLeft = insertionSortLL(LHead, reversed);
                LLNode<T> sortedRight = insertionSortLL(RHead, reversed);
                return combine(sortedLeft, sortedRight);
            }
        }
    }

    public static <T extends Comparable<T>> LLNode<T> combine(LLNode<T> left, LLNode<T> right) {
        LLNode<T> current = left;
        while(current.next() != null) {
            current = current.next();
        }
        current.setNext(right);
        return left;
    }    

    public static <T extends Comparable<T>> LLNode<T> getMid(LLNode<T> head) {
        if (head == null) { 
            return head; 
        }
        LLNode slow, fast; 
        slow = fast = head;
        while(fast.next() != null && fast.next().next() != null) {
            slow = slow.next(); fast = fast.next().next();
        }
        return slow;
    }

    // private static <T extends Comparable<T>> LLNode<T> getMiddle(LLNode<T> list) {
    //     LLNode cur1 = list;
    //     LLNode cur2 = list;
    //     while (cur2.next() != null) {
    //         cur2 = cur2.next();
    //         if (cur2.next() != null) {
    //             cur2 = cur2.next();
    //             cur1 = cur1.next();
    //         }
    //     }
    //     return cur1;
    // }

    // private static <T extends Comparable<T>> LLNode<T> getMiddle(LLNode<T> list) {
    //     LLNode current = list;
    //     int size = 0;

    //     // Get size.
    //     while (current != null) {
    //         size++;
    //         current = current.next();
    //     }

    //     // Get middle.
    //     int half = size / 2;
    //     current = list;
    //     for (int i = 1; i < half; i++) {
    //         current = current.next();
    //     }

    //     return current;
    // }

    public static <T extends Comparable<T>> LLNode<T> quickSortLL(LLNode<T> list, boolean reversed) {
        return null;
    }

    private static <T extends Comparable<T>> LLNode<T> partitionLL(LLNode<T> a, LLNode<T> b) {
        return null;
    }    

    // 1 Sorting algorithm that sorts an Array of ints
   
    public static void bucketSort(int[] array, int low, int high, boolean reversed) {
        // Get number of buckets.
        int buckets = (high - low + 1) / 2;

        // Get min and max.
        int min = array[low];
        int max = array[low];
        for (int i = low; i <= high; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        // Get capacity of each bucket.
        int bucketCapacity = (max - min) / buckets;

        // Fill bucketArray.
        LLNode[] bucketArray = new LLNode[buckets];
        int bucketNum;
        for (int i = low; i <= high; i++) {
            // TODO get the correct bucketNum!
            bucketNum = (max - min) / array[i];
            // TODO how do we know when an index is empty?
            if (bucketArray[bucketNum] == null) {
                bucketArray[bucketNum] = new LLNode(array[i]);
            }
            else {
                LLNode node = new LLNode(array[i]);
                node.setNext(bucketArray[bucketNum]);
                bucketArray[bucketNum] = node;
            }
        }

        // Sort each linked list in bucketArray.
        for (LLNode node : bucketArray) {
            selectionSortLL(node, reversed);
        }

        // Repopulate the original array.
        int i = low;
        for (LLNode node : bucketArray) {
            while (node != null) {
                array[i] = (Integer) node.elem();
                i++;
                node = node.next();
            }
        }

    }

    // 1 Sorting algorithm that sorts an Array of Strings

    // public static void radixSort(String[] array, int low, int high, boolean reversed) {
    //     // Get the length of the longest string.
    //     int max = array[0].length();
    //     for (String str : array) {
    //         if (str.length() > max) {
    //             max = str.length();
    //         }
    //     }

    //     for (int exp = 1; max / exp > 0; exp *= 10) {
    //         countSort(array, max);
    //     }

    //     // How do we put the elems in the new array?
    // }

    // public static void countSort(String[] array, int max) {
    //     int[] count = new int[max+1];
    //     for (int i = 0; i <= max; i++) {
    //         count[i] = 0;
    //     }
    //     for (int i = 0; i < array.length; i++) {
    //         count[array[i]]++;
    //     }
    //     int index = 0;
    //     for (int i = 0; i < max; i++) {
    //         for (int j = 0; j < count[i]; j++) {
    //             array[index++] = i;
    //         }
    //     }
    // }
    
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
