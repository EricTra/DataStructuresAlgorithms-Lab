package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private int size;
    private static class Node<E> {
        public E element;
        public Node<E> previous;
        private Node<E> next;
        public Node(E value) {
            this.element = value;
        }
    }
    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null ) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }
    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node <E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }
    public void ensureNonEmpty(){
        if(head == null) {
            throw new IllegalStateException("Queue is Empty !!");
        }
    }
    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head.element;
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
            private Node<E> current = head;
            @Override
            public boolean hasNext(){ return current != null; }
            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}
