package interfaces;

public interface LinkedList<E> extends Iterable<E> {
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();

    E removeAtIndex(int index);

    E getFirst();
    E getLast();

    E getAtIndex(int index);

    int size();
    boolean isEmpty();

    void addAtIndex(E element, int index);
}
