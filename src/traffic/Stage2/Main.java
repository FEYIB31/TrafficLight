package traffic.Stage2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int action = 1;

    System.out.println("Welcome to the traffic management system!");
    getRoads();
    getIntervals();


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
    return Integer.parseInt(scanner.nextLine());
  }

  public static void getRoads() {
    System.out.print("Input the number of roads: ");
    scanner.nextLine();
  }

  public static void getIntervals() {
    System.out.print("Input the interval: ");
    scanner.nextLine();
  }

  public static void printAction(int action) {
    switch(action) {
      case 1:
        System.out.println("Road added");
        break;
      case 2:
        System.out.println("Road deleted");
        break;
      case 3:
        System.out.println("System opened");
        break;
      case 0:
        System.out.println("Bye!");
        return;
      default:
        break;
    }
  }
}
