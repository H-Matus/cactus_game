
package com.example.cactus_game.model;

public interface Deck {
  public void fillDeck();

  public Card drawCard();

  public void addCard(Card card);

  public void shuffle();

  public Card readTopCard();

  public int getSize();
}
