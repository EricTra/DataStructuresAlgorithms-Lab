package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;
    private static class Node<E> {
        public Node<E> previous;
        private E element;
        private Node<E> next;
        public Node(E value) {
            this.element = value;
        }
    }
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    @Override
    public E pop() {
        ensureNonEmpty();
        E element = this.top .element;
        Node<E> temp = this.top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;
        return element;
    }
    private void ensureNonEmpty(){
        if (top == null){
            throw new IllegalStateException("Stack is empty!!");
        }
    }
    @Override
    public E peek() {
        ensureNonEmpty();
        return this.top.element;
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
            private Node<E> current = top;
            @Override
            public boolean hasNext(){ return current != null; }
            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.previous;
                return element;
            }

        };
    }
}
