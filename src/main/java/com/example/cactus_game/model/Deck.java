
package com.example.cactus_game.model;

import java.util.ArrayDeque;

public class Deck {
  private ArrayDeque<Card> cards;

  public Deck(int size) {
    this.cards = new ArrayDeque<Card>();
  }

  public void shuffle() {}
}
