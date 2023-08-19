import Searching.BinarySearch;
import  implementations.*;

import java.util.Iterator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Queue2<String> bufferQueue = new Queue2<>();
        Stack2<String> messageStack = new Stack2<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\u001B[1m" + "-----------------------------------");
            System.out.println("|        Welcome to the Demo       |");
            System.out.println("|     Written by DuyTea            |");
            System.out.println("-----------------------------------\u001B[0m");
            System.out.println("\u001B[1m" + "1. Enqueue message to Buffer Queue");
            System.out.println("2. Process messages to Message Stack");
            System.out.println("3. Pop message from Message Stack and Print");
            System.out.println("4. Exit\u001B[0m");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the message to enqueue: ");
                    String enqueueMessage = scanner.nextLine();
                    bufferQueue.offer(enqueueMessage);
                    System.out.println("Message enqueued to Buffer Queue.");
                    break;

                case 2:
                    while (!bufferQueue.isEmpty()) {
                        String dequeuedMessage = bufferQueue.poll();
                        messageStack.push(dequeuedMessage);
                    }
                    System.out.println("Messages processed to Message Stack.");
                    break;

                case 3:
                    if (!messageStack.isEmpty()) {
                        String poppedMessage = messageStack.pop();
                        System.out.println("Popped message from Message Stack: " + poppedMessage);
                    } else {
                        System.out.println("Message Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
