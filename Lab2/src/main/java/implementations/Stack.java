package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    // Using array
    private E[] elements;
    private int size;

    public Stack() {
        this.elements = (E[]) new Object[999];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void push(E element) {
        if (this.size == this.elements.length) {
            this.elements = this.grow();
        }
        this.elements[this.size++] = element;
    }

    private E[] grow() {
        E[] newElements = (E[]) new Object[this.elements.length * 2];
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        return newElements;
    }

    @Override
    public E pop() {
        ensureNonEmpty();
        E element = this.elements[--this.size];
        this.elements[this.size] = null;
        return element;
    }

    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.elements[this.size - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override
            public E next() {
                return elements[index--];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.size - 1; i >= 0; i--) {
            sb.append(this.elements[i]).append(" ");
        }
        return sb.toString();
    }
}
