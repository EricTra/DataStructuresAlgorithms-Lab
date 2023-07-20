package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue2<E> implements AbstractQueue<E> {
    private ArrayList<E> head2;
    private int size;
    public Queue2() {
        this.head2 = new ArrayList<>();
        this.size = 0;
    }
    @Override
    public void offer(E element) {
        this.head2.add(element);
        this.size++;
    }
    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.head2.remove(0);
        this.size--;
        return element;
    }
    public void ensureNonEmpty(){
        if(head2 == null) {
            throw new IllegalStateException("Queue is Empty !!");
        }
    }
    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head2.get(0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ArrayList<E> current = head2;
            int index = 0;
            @Override
            public boolean hasNext(){ return (index < size); }
            @Override
            public E next() {
                index++;
                return head2.get(index-1);
            }
        };
    }
}
