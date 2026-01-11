
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
          int numPlayers = 0;

          System.out.println("Starting Cactus game...");
          System.out.print("Insert the number of players in the game (2 <= x <= 4): ");
          while (numPlayers < Cactus.MIN_NUM_PLAYERS || Cactus.MAX_NUM_PLAYERS > 4) {
            numPlayers = Integer.parseInt(scanner.nextLine());
          }

          Cactus cactus = new Cactus(2);
          cactus.setup();
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
