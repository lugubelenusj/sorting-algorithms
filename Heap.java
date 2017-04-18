public class Heap {

    private int[] HeapData;
    private int maxsize;
    private int size;

    public Heap(int max) {
        maxsize = max;
        HeapData = new int[maxsize];
        HeapData[0] = Integer.MIN_VALUE;
        size = 0;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int parent(int pos) {
        return (pos / 2);
    }

    private boolean isLeaf(int pos) {
        return ((pos > size/2) && (pos <= size));
    }

    private void swap(int pos1, int pos2) {
        int temp = HeapData[pos1];
        HeapData[pos1] = HeapData[pos2];
        HeapData[pos2] = temp;
    }

    public void insert(int elem) {
        int current = size++;
        HeapData[size] = elem;

        while (HeapData[current] < HeapData[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int removemin() {
        swap(1, size);
        size--;
        if (size != 0) {
            siftdown(1);
        }
        return HeapData[size+1];
    }

    private void siftdown(int position) {
        int smallestChild;
        while (!isLeaf(position)) {
            smallestChild = leftChild(position);
            if ((smallestChild < size) && (HeapData[smallestChild]) > HeapData[smallestChild+1]) {
                smallestChild = smallestChild + 1;
            }
            if (HeapData[position] <= HeapData[smallestChild]) {
                return;
            }
            swap(position, smallestChild);
            position = smallestChild;
        }
    }

}