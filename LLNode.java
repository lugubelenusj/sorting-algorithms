class LLNode<T extends Comparable<T>> {

    public LLNode(T  elem, LLNode<T> next) {
        _elem = elem;
        _next = next;
    }

    public LLNode(T elem) {
        _elem = elem;
        _next = null;
    }

    public T elem() {
        return _elem;
    }

    public LLNode<T> next() {
        return _next;
    }

    public void setElem(T elem) {
        _elem = elem;
    }

    public void setNext(LLNode<T> next) {
        _next = next;
    }

    private T _elem;
    private LLNode<T> _next;

}
