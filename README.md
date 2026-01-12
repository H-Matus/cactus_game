# Cactus

A Java-based implementation of a modified Cactus card game. It is a memory based game, requiring players to guess and remember hidden cards in their hands.

## Rules
- Goal: Have your four hidden cards (found in a hand) equal to the value of 5 or less after you or another player has called "Cactus!". If none of players have a value of 5, the player with lowest total hand value wins.
- Point system:
  - Ace = 1 point
  - King = 0 points
  - Queen = 10 points
  - Jack = 10 points
  - Other cards = pip value
- Special cards:
  - 8 - Allows player to look at one their cards.
  - Jack - Allows player to swap one of their cards with any other player's cards. No looking is allowed.

## Features
- Interfaces for Hands, Decks, Games and Shuffling methods, which improve modularity of the program.
- Model of a 52 card deck, which can contain jokers.
- Shuffling mechanism, which uses Collections.shuffle() method.
- CLI-based UI.


## Missing Features
- Reshuffling discard deck into main deck once main deck is exhausted.
- Hand value tie management.
- Special card handling.
- Multiplayer functionality to obfuscate drawn cards from other players in a more intuitive way.
- Player class to more naturally handle hands.
- Addition of multiple games.

## Evaluation
The project is split into five main components:
- game:
  - contains rules and logic of each game.
- model:
  - contains the model for suits, ranks, cards and decks.
- ui:
  - contains ui code.
  - could contain GUI code as well to swap between the two.
- util:
  - any other helpful modules.
- Main.java
  - initialises and executes the UI, which allows to select the game.


## Launch Instructions
To build a package using Maven in root directory:
```
mvn package
```
Then run the program by using this command from root directory:
```
java -jar target/cactus_game-1.0-SNAPSHOT.jar
```
To clean and then build the package using Maven in root directory:
```
mvn clean package
```
