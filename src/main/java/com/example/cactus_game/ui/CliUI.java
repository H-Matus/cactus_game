
package com.example.cactus_game.ui;

import com.example.cactus_game.game.Cactus;
import com.example.cactus_game.model.Card;
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
          while (numPlayers < Cactus.MIN_NUM_PLAYERS || Cactus.MAX_NUM_PLAYERS > 4) {
            System.out.print("Insert the number of players in the game (2 <= x <= 4): ");
            numPlayers = Integer.parseInt(scanner.nextLine());
          }

          Cactus cactus = new Cactus(numPlayers);
          cactus.setup();

          int playerIdx = 0;
          int cardIdx = 0;
          String deckInput = "";
          String actionInput = "";
          String cactusCallInput = "";

          while (!cactus.isFinished()) {
            System.out.println("Player " + playerIdx + ":");
            System.out.println("Top discard card is: " + cactus.readDiscardDeckTopCard());

            while (true) {
              System.out.println("Enter the keyword of the option:");
              System.out.println("main - to draw from the main deck.");
              System.out.println("discard - to draw from the discard deck.");

              deckInput = scanner.nextLine().toLowerCase();
              if (deckInput.equals("main")) {
                Card pickedCard = cactus.drawDeckCard();
                System.out.println("Picked card: " + pickedCard);

                while (true) {
                  System.out.println("Enter the keyword of the option:");
                  System.out.println("replace - to replace a card.");
                  System.out.println("discard - to discard the card.");

                  actionInput = scanner.nextLine().toLowerCase();
                  if (actionInput.equals("discard")) {
                    cactus.playTurn(pickedCard);
                    break;
                  } else if (actionInput.equals("replace")) {
                    while (true) {
                      System.out.println("Enter which card in hand to replace (1, 2, 3, 4):");

                      cardIdx = Integer.parseInt(scanner.nextLine());
                      if (cardIdx >= 1 && cardIdx <= 4) {
                        cactus.playTurn(playerIdx, cardIdx, deckInput, actionInput, pickedCard);
                        break;
                      } else {
                        System.out.println("Wrong input. Try again.");
                      }
                    }
                    break;
                  } else {
                    System.out.println("Wrong input. Try again.");
                  }
                }
                break;
              } else if (deckInput.equals("discard") && cactus.getDiscardDeckSize() > 0) {
                Card pickedCard = cactus.drawDiscardDeckCard();
                System.out.println("Picked card: " + pickedCard);

                while (true) {
                  System.out.println("Enter which card in hand to replace (1, 2, 3, 4):");

                  cardIdx = Integer.parseInt(scanner.nextLine());
                  if (cardIdx >= 1 && cardIdx <= 4) {
                    cactus.playTurn(playerIdx, cardIdx, deckInput, actionInput, pickedCard);
                    break;
                  } else {
                    System.out.println("Wrong input. Try again.");
                  }
                }
                break;
              } else {
                System.out.println("Wrong input or No cards in discard deck. Try again.");
              }
            }

            if (!cactus.isCactusCalled()) {
              while (true) {
                System.out.println("Call Cactus? Yes / No");
                cactusCallInput = scanner.nextLine();
                if (cactusCallInput.equals("Yes") || cactusCallInput.equals("No")) {
                  cactus.callCactus(playerIdx, cactusCallInput);
                  break;
                } else {
                  System.out.println("Wrong input. Try again.");
                }
              }
            }

            playerIdx++;
            if (playerIdx == numPlayers) {
              playerIdx = 0;
            }
          }

          System.out.println("Winner: Player " + cactus.getWinner());

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
