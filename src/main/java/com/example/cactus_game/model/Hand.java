
package com.example.cactus_game.model;

public interface Hand {
  public void addCard(Card card, int idx);

  public Card removeCard(int idx);

  public void peekCard(int idx);
}
