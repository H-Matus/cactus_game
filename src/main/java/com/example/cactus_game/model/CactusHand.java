
package com.example.cactus_game.model;

public class CactusHand implements Hand {
  public static final int HAND_SIZE = 4;

  private Card handCards[];

  public CactusHand(Card[] cards) {
    this.handCards = cards;
  }

  public void addCard(Card card, int idx) {
    this.handCards[idx] = card;
  }

  public Card removeCard(int idx) {
    return this.handCards[idx];
  }

  public void peekCard(int idx) {
    System.out.println(handCards[idx]);
  }

  public String toString() {
    String ret = "";

    ret += "Hand cards:\n";
    for (int i = 0; i < HAND_SIZE; i++) {
      ret += this.handCards[i] + "\n";
    }

    return ret;
  }
}
