
package com.example.cactus_game.game;

import com.example.cactus_game.model.CactusDeck;
import com.example.cactus_game.model.Card;
import com.example.cactus_game.model.Rank;
import com.example.cactus_game.model.Suit;

/**
 *
 */
public class Cactus implements Game {
  /**
   *
   */
  private int numPlayers;

  private CactusDeck deck;

  /**
   *
   */
  public Cactus(int numPlayers) {
    this.numPlayers = numPlayers;
    this.deck = new CactusDeck();
  }

  public Cactus() {
    this.numPlayers = 2;
    this.deck = new CactusDeck();
  }

  /**
   *
   */
  @Override
  public void start() {
    System.out.println("Starting Cactus game...");
    this.setup();
  }

  @Override
  public void playRound() {}

  @Override
  public void playTurn(String playerInput) {}

  private void setup() {
    System.out.println("Testing the deck:");
    System.out.println(this.deck);
    System.out.println("Picking a card:");
    this.deck.drawCard();
    System.out.println("this.deck");
    System.out.println("Reshuffling the deck:");
    this.deck.shuffle();
    System.out.println(this.deck);
    System.out.println("Adding a card:");
    this.deck.addCard(new Card(Suit.SPADES, Rank.ACE));
    System.out.println(this.deck);
  }
}
