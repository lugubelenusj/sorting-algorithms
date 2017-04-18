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
   
    public static <T extends Comparable<T>> void heapSort(T[] array, int lowindex, int highindex, boolean reversed) {
    
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

    public static <T extends Comparable<T>> void optimizedQuickSort(T[] array, int lowindex, int highindex, boolean reversed) {
        if (array.length < 10) {
            insertionSort(array, lowindex, highindex, reversed);
        }
        if (lowindex < highindex) {
            int mid = partition(array, lowindex, highindex, reversed);
            quickSort(array, lowindex, mid, reversed);
            quickSort(array, mid+1, highindex, reversed);
        }
    }

    // 4 Sorting algorithms that sort Linked Lists of Comparables

    // public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed) {
    //     LLNode cur1 = list.next();
    //     while (cur1 != null) {
    //         //T insertElem = cur1.elem();
    //         LLNode cur2 = cur1;
    //         while (cur2.next() != list && cur2.next() != null) {
    //             if (cur2.elem().compareTo(cur2.next().elem()) <= 0) {
    //                 swapNodes(cur2, cur2.next());
    //             }
    //             cur2 = cur2.next();
    //         }
    //     }
    //     return list;
    // }

    // public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed) {
    //     LLNode cur1 = list.next();
    //     int cur1Index = 1;

    //     while (cur1 != null) {

    //         LLNode cur2 = list;
    //         for (int i = 0; i < cur1Index; i++) {
    //             cur2 = cur2.next();
    //         }

    //         for (LLNode temp = cur2; temp.next() != list && temp.next().elem().compareTo(cur1.elem()) > 0; temp = temp.next()) {
    //             temp.next().setElem(temp.elem());
    //         }
    //         cur2.setElem(cur1.elem());
    //     }
    //     return list;
    // }

    public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed) {
        LLNode current = list;
        return list;
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
        if (list == null || list.next() == null) {
            return list;
        }
        LLNode middle = getMiddle(list);
        LLNode secondHalf = middle.next();
        middle.setNext(null);

        return merge(mergeSortLL(list, reversed), mergeSortLL(secondHalf, reversed));
    }

    private static <T extends Comparable<T>> LLNode<T> merge(LLNode<T> a, LLNode<T> b) {
        LLNode dummyHead, curr; 
        dummyHead = new LLNode(0); 
        curr = dummyHead;
        while (a != null && b != null) {
            if (a.elem().compareTo(b.elem()) <= 0) { 
                curr.setNext(a); 
                a = a.next(); 
            }
            else { 
                curr.setNext(b); 
                b = b.next(); 
            }
            curr = curr.next();
        }
        if (a == null) {
            curr.setNext(b);
        }
        else {
            curr.setNext(a);
        }
        return dummyHead.next();
    }

    public static <T extends Comparable<T>> LLNode<T> getMiddle(LLNode<T> head) {
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

    // public static <T extends Comparable<T>> LLNode<T> quickSortLL(LLNode<T> list, boolean reversed) {
    //     if (list == null || list.next() == null) {
    //         return list;
    //     }

    //     LLNode pointer = list;
    //     while (pointer != null) {
    //         pointer = pointer.next();
    //     }
    //     LLNode high = pointer;
    //     LLNode low = list;

    //     LLNode mid = partitionLL(low, high, reversed);
    // }

    // public static <T extends Comparable<T>> LLNode<T> partitionLL(LLNode<T> low, LLNode<T> high, boolean reversed) {
    //     LLNode pivot = low;
    //     LLNode i = low;
    //     LLNode j = high.next();;
    //     while (i < j) {
    //         for (i++; array[i].compareTo(array[pivot]) < 0; i++);
    //         for (j--; array[j].compareTo(array[pivot]) > 0; j--);
    //         if (i < j) {
    //             swapNodes(i, j);
    //         }
    //     }
    //     return j;
    // }    

    // public static <T extends Comparable<T>> LLNode<T> quickSortLL(LLNode<T> list, LLNode low, LLNode high, boolean reversed) {

    // }

    private static <T extends Comparable<T>> LLNode<T> partitionLL(LLNode<T> a, LLNode<T> b) {
        return null;
    }    

    // 1 Sorting algorithm that sorts an Array of ints
   
    public static void bucketSort(int[] array, int lowindex, int highindex, boolean reversed) {
        // Get number of buckets.
        int buckets = (highindex - lowindex + 1) / 2;

        // Get min and max.
        int min = array[lowindex];
        int max = array[lowindex];
        for (int i = lowindex; i <= highindex; i++) {
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
        for (int i = lowindex; i <= highindex; i++) {
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
        int i = lowindex;
        for (LLNode node : bucketArray) {
            while (node != null) {
                array[i] = (Integer) node.elem();
                i++;
                node = node.next();
            }
        }

    }

    // 1 Sorting algorithm that sorts an Array of Strings

    public static void radixSort(String[] array, int lowindex, int highindex, boolean reversed) {
        // Get the length of the longest string.
        int max = array[0].length();
        for (String str : array) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        // How do we put the elems in the new array?
    }

    // public static void countSort(String[] array, int lowindex, int highindex, boolean reversed) {
    //     int size = highindex - lowindex + 1;
    //     int output[] = new int[n]; // output array
    //     int i;
    //     int count[] = new int[10];
    //     Arrays.fill(count,0);
 
    //     // Store count of occurrences in count[]
    //     for (i = 0; i < n; i++)
    //         count[ (arr[i]/exp)%10 ]++;
 
    //     // Change count[i] so that count[i] now contains
    //     // actual position of this digit in output[]
    //     for (i = 1; i < 10; i++)
    //         count[i] += count[i - 1];
 
    //     // Build the output array
    //     for (i = n - 1; i >= 0; i--)
    //     {
    //         output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
    //         count[ (arr[i]/exp)%10 ]--;
    //     }
 
    //     // Copy the output array to arr[], so that arr[] now
    //     // contains sorted numbers according to curent digit
    //     for (i = 0; i < n; i++)
    //         arr[i] = output[i];
    // }

    // We can pass in the original array with the lowindex and highindex as params, or make a new array in the parent spliced method and pass that in.
    // public static void countingSort(String[] array, )
    
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
