public class Main {

    // reference to head / first node of the Singly Linked List
    public Node head = null;

    // class Node that hold data and a reference/link
    // to the next Node in the list
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
     * Method to add a node at the beginning of the list
     */
    public void addNodeAtTheBeginning(int data) {
        System.out.println("Add a node with data " + data + " in the beginning.");
        // Create a new node
        Node newNode = new Node(data);

        // Check if the list is empty
        if (this.head == null) {
            // Make the new node as head
            this.head = newNode;
        } else {
            // Point the new node's next to head
            newNode.next = this.head;

            // Make the new node as head
            this.head = newNode;
        }
    }

    /*
     * Method to add a node at the end of the list
     */
    public void addNodeAtTheEnd(int data) {
        System.out.println("Add a node with data " + data + " at the end.");
        // Create a new node
        Node newNode = new Node(data);

        // Check if the list is empty
        if (this.head == null) {
            // Make the new node as head
            this.head = newNode;
        } else {
            Node cur = this.head;
            // traverse to the end of the list
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }


    /*
     * Method to add a node at the specified position in the list
     */
    public void add(int position, int data) {
        System.out.println("Add a node with data " + data + " at the position " + position);
        // Create a new node
        Node newNode = new Node(data);

        // Init the cur and prev nodes to the head
        Node cur = this.head, prev = this.head;

        if (position == 1) {
            // Point the new node's next to head
            newNode.next = head;
            // Make the new node as head
            this.head = newNode;
            return;
        }

        // traverse to the end of the list and check positions moved
        while (cur.next != null && --position > 0) {
            // update the prev and cur references
            prev = cur;
            cur = cur.next;
        }

        // update prev to point to new node
        prev.next = newNode;

        // & new node to point to current node
        newNode.next = cur;
    }

    public void print() {
        if (this.head == null) {
            System.out.println("The List is empty.");
        } else {
            System.out.println("The contents of the Singly Linked List are : ");
            Node cur = this.head;
            while (cur != null) {
                System.out.print(cur.data + " -> ");
                cur = cur.next;
            }
            System.out.println("NULL\n");
        }
    }

    public static void main(String[] args) {
        Main list = new Main();
        System.out.println("Created a singly linked list .....");
        list.print();
        list.addNodeAtTheBeginning(100);
        list.print();
        list.addNodeAtTheBeginning(200);
        list.print();
        list.addNodeAtTheEnd(900);
        list.print();
        list.addNodeAtTheEnd(800);
        list.print();
        list.add(1,150);
        list.print();
        list.add(4,250);
        list.print();
        list.add(6,250);
        list.print();
    }
}