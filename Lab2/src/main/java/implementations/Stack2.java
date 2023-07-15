package implementations;
import interfaces.AbstractStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack2<E> implements AbstractStack<E> {
    private List<E> elements;

    public Stack2() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void push(E element) {
        elements.add(element);
    }

    @Override
    public E pop() {
        ensureNonEmpty();
        return elements.remove(elements.size() - 1);
    }

    private void ensureNonEmpty() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return elements.get(elements.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = elements.size() - 1; i >= 0; i--) {
            sb.append(elements.get(i)).append(" ");
        }
        return sb.toString();
    }
}
