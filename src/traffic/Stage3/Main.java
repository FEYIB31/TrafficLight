package traffic.Stage3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the traffic management system!");
        getInput("Input the number of roads: ");
        getInput("Input the interval: ");
        clearConsole();

        start();
    }

    public static void start() {
        int action = 1;

        while (action != 0) {
            Menu();
            action = getAction();
            printAction(action);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        System.out.println("Menu:");
        System.out.println("1. Add road");
        System.out.println("2. Delete road");
        System.out.println("3. System system");
        System.out.println("0. Quit");
    }

    public static int getAction() {
        int input;

        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {

                System.out.println("Incorrect option");
                scanner.nextLine();
                Menu();
            }
        }

        return input;
    }

    public static void getInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input <= 0) {
                    System.out.print("Error! Incorrect Input. Try again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error! Incorrect Input. Try again: ");
            }
        }
    }


    public static void clearConsole() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
        }
    }

    public static void printAction(int action) {

        if ((action >= 0) && (action <= 3)) {
            switch (action) {
                case 1:
                    System.out.println("Road added");
                    break;
                case 2:
                    System.out.println("Road deleted");
                    break;
                case 3:
                    System.out.println("Open system");
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    break;
            }
        } else {
            System.out.println("Incorrect option");
        }

        scanner.nextLine();
    }
}
