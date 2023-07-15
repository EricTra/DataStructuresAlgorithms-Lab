import implementations.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
testStack();
    }
    public static void testStack(){
        Stack<Integer> stackNode = new Stack<Integer>();
        stackNode.push(1);
        stackNode.push(3);
        stackNode.push(5);
        stackNode.push(7);
        System.out.println(stackNode);

        // Pop 2 element
        System.out.println(stackNode.pop());
        System.out.println(stackNode.pop());
        System.out.println();

        // Peek element
        System.out.println(stackNode.peek());
        System.out.println();

        // Check size
        System.out.println(stackNode.size());
        System.out.println();

        // Check Empty
        System.out.println(stackNode.isEmpty());
        System.out.println();

        // Iterator
        Iterator<Integer> stackIterator = stackNode.iterator();
        while (stackIterator.hasNext()){
            System.out.println(stackIterator.next());
        }
    }
}
