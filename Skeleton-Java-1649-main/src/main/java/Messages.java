import java.io.*;
import java.util.Scanner;
import implementations.*;

public class Messages {
    private Queue2<String> messageQueue = new Queue2<>();
    private Stack2<String> messageStack = new Stack2<>();

    public static void main(String[] args) throws IOException {
        Messages messages = new Messages();
        messages.menu();
    }

    public void menu() throws IOException {
        Scanner scn = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            clearScreen();
            showMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scn.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        String message = inputMessage();
                        sendMessage(message);
                        break;
                    case 2:
                        processStack();
                        break;
                    case 3:
                        printStack();
                        break;
                    case 4:
                        System.out.println("Exiting the program. Have a good day!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
            }
        }
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Send Message");
        System.out.println("2. Process Stack");
        System.out.println("3. Print Stack");
        System.out.println("4. Exit");
    }
    public String inputMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Message: ");
        String text = scanner.nextLine();
        return text;
    }

    public void sendMessage(String message) {
        if (message.trim().isEmpty()) {
            System.out.println("Invalid input: The message is empty. Please enter a valid message.");
            return;
        }
        if (message.length() > 250) {
            System.out.println("Invalid input: The message length exceeds 250 characters. Please enter a shorter message.");
            return;
        }

        String[] result = message.split("\\.");
        for (String part : result) {
            if (!part.trim().isEmpty()) {
                messageQueue.offer(part);
            }
        }
        System.out.println("Messages added to the queue.");
    }

    public void processStack() {
        if (messageQueue.isEmpty()) {
            System.out.println("The message queue is empty. Please send messages to the queue first.");
            return;
        }

        long startProcessingTime = System.currentTimeMillis();

        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endProcessingTime = System.currentTimeMillis();
        long processingTime = endProcessingTime - startProcessingTime;
        System.out.println("Messages processed and moved to the stack.");
        System.out.printf("Processing Time: %d ms%n", processingTime);
    }

    public void printStack() {
        if (messageStack.isEmpty()) {
            System.out.println("The stack is empty. No messages to display.");
            return;
        }

        System.out.println("Display Stack: ");
        for (String message : messageStack) {
            System.out.println(message);
        }
    }
}
