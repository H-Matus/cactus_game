
package com.example.cactus_game.model;

public enum Rank {
  JOKER(0),
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(10),
  QUEEN(10),
  KING(0);

  private int value;

  private Rank(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
