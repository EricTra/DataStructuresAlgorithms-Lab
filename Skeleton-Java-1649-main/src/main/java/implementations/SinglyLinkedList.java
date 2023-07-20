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
        }
        this.size++;
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
        Node<E> removeNode = this.head;
        while (removeNode.next != this.tail){
            removeNode = removeNode.next;
        }
        this.tail.next = null;
        this.tail = removeNode;
        this.size--;
        return removeNode.next.element;
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
        return null;
    }
}
