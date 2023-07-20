package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack2<E> implements AbstractStack<E> {
    private ArrayList<E> stack2;
    private int size;

    public Stack2() {
        this.stack2 = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public void push(E element){
        stack2.add(element);
        this.size++;
    }

    @Override
    public E pop() {
        ensureNonEmpty();
        E element = stack2.remove(stack2.size()-1);
        this.size--;
        return element;
    }
    private void ensureNonEmpty(){
        if (stack2.isEmpty()){
            throw new IllegalStateException("Stack is empty!!");
        }
    }
    @Override
    public E peek() {
        ensureNonEmpty();
        return stack2.get(stack2.size() - 1);
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
            private ArrayList<E> current = stack2;
            private int index = 0;
            @Override
            public boolean hasNext(){ return index < current.size(); }
            @Override
            public E next() {
                return  current.remove(current.size() - 1);
            }
        };
    }
}
