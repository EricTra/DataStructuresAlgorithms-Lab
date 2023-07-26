package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> T = new Node<>(element);
        if (this.head == null) {
            this.head = T;
            this.tail = T;
        } else {
            T.next = this.head;
            this.head.prev = T;
            this.head = T;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> T = new Node<>(element);
        if (this.head == null) {
            this.head = T;
            this.tail = T;
        } else {
            this.tail.next = T;
            T.prev = this.tail;
            this.tail = T;
        }
        this.size++;
    }

    public void insertAfterIndex(E element, int index) {
        Node<E> T = new Node<>(element);
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        T.next = temp.next;
        temp.next.prev = T;
        temp.next = T;
        T.prev = temp;
        this.size++;
    }

    @Override
    public E removeFirst() {
        if (this.head == null) {
            throw new IllegalArgumentException("The list is empty");
        } else {
            Node<E> T = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return T.element;
        }
    }

    @Override
    public E removeLast() {
        if (this.head == null) {
            throw new IllegalArgumentException("The list is empty");
        } else {
            Node<E> T = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return T.element;
        }
    }

    @Override
    public E removeAtIndex(int index) {
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        this.size--;
        return temp.element;
    }

    @Override
    public E getFirst() {
        if (this.head == null) {
            throw new IllegalArgumentException("The list is empty");
        } else {
            return this.head.element;
        }
    }

    @Override
    public E getLast() {
        if (this.head == null) {
            throw new IllegalArgumentException("The list is empty");
        }
        return this.tail.element;
    }

    @Override
    public E getAtIndex(int index) {
        if (this.head == null) {
            throw new IllegalArgumentException("The list is empty");
        }
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addAtIndex(E element, int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAtIndex'");
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> temp = this.head;
        while (temp != null) {
            sb.append(temp.element).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }
}