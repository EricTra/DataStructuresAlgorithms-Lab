package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head, tail;
    private int size;
    private static class Node<E>{

        public E element;
        public Node<E> next;
        public Node<E> previous;
        public Node(E value) { this.element = value;
        }
    }
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = null;
        }
        this.size++;
    }
    public void addInside(E front, E element) {
        Node<E> newNode = new Node<>(element);
        Node<E> frontNode = this.head;
        if ( front == this.head.element) addFirst(element);
        else if (front == this.tail.element) addLast(element);
        else {
            while (frontNode.element != front) {
                frontNode = frontNode.next;
            }
            Node<E> temp =  frontNode.next;
            frontNode.next = newNode;
            newNode.next = temp;
        }
    }
    @Override
    public E removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node<E> oldNode = this.head;
        this.head = this.head.next;
        oldNode.next = null;
        this.size--;
        return oldNode.element;
    }

    @Override
    public E removeLast() {
        if (this.tail == null) {
            return null;
        }

        if (this.head == this.tail) {
            Node<E> removedNode = this.head;
            this.head = null;
            this.tail = null;
            this.size--;
            return removedNode.element;
        }
        Node<E> removeNode = this.head;
        while (removeNode.next != this.tail) {
            removeNode = removeNode.next;
        }
        this.tail = removeNode;
        this.tail.next = null;
        this.size--;
        return this.tail.element;
    }

    public void removeInside(E element) {
        Node<E> find = this.head;
        Node<E> temp = null;
        while (find.element != element) {
            temp = find;
            find = find.next;
        }
        find = find.next;
        if (temp != null) {
            temp.next = find;
        }
    }
    @Override
    public E getFirst() {
        return this.head.element;
    }
    @Override
    public E getLast() {
        return this.tail.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private SinglyLinkedList.Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }

}
