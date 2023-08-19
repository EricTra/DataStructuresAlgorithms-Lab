package Message;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferQueue bufferQueue = new BufferQueue();
        MessageStack messageStack = new MessageStack();

        while (true) {
            clearScreen();
            printStyledMenu();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter message content: ");
                        String content = scanner.nextLine();
                        if (content.length() > 250) {
                            throw new RuntimeException("Message content exceeds 250 characters.");
                        } else {
                            bufferQueue.enqueueMessage(new Message(content));
                            System.out.println("Message enqueued.");
                        }
                        break;

                    case 2:
                        while (bufferQueue.size() > 0) {
                            Message dequeuedMessage = bufferQueue.dequeueMessage();
                            messageStack.pushMessage(dequeuedMessage);
                        }
                        System.out.println("All messages processed and pushed to stack.");
                        break;

                    case 3:
                        try {
                            while (messageStack.size() > 0) {
                                Message poppedMessage = messageStack.popMessage();
                                System.out.println("Popped message: " + poppedMessage.getContent());
                            }
                        } catch (IllegalStateException e) {
                            System.out.println("Stack is empty");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine(); // Wait for Enter key
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printStyledMenu() {
        System.out.println("\u001B[1m" + "-----------------------------------");
        System.out.println("|        Welcome to the Demo       |");
        System.out.println("|     Written by DuyTea            |");
        System.out.println("-----------------------------------\u001B[0m");
        System.out.println("\u001B[1m" + "1. Enqueue message to Buffer Queue");
        System.out.println("2. Process messages to Message Stack");
        System.out.println("3. Pop message from Message Stack and Print");
        System.out.println("4. Exit\u001B[0m");
    }
}