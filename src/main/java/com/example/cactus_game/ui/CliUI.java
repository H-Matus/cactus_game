
package com.example.cactus_game.ui;

import com.example.cactus_game.game.Cactus;
import java.util.Scanner;

public class CliUI {
  public CliUI() {}

  public void start() {
    boolean exit = false;

    while (exit != true) {
      printMenu();

      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      switch (input) {
        case "1":
          Cactus cactus = new Cactus();
          cactus.start();
          break;
        case "2":
          System.out.println("Exiting the program.");
          exit = true;
          scanner.close();
          break;
        default:
          System.out.println("Wrong input.");
          break;
      }
    }
  }

  private void printMenu() {
    System.out.println("-------------------");
    System.out.println("Menu");
    System.out.println("-------------------");
    System.out.println("1. Cactus");
    System.out.println("2. Exit");
    System.out.println("-------------------");
    System.out.print("Please insert the number of the option:");
    System.out.println("");
  }
}
