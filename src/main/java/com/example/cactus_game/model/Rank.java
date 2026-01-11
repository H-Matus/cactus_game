
package com.example.cactus_game.model;

public enum Rank {
  JOKER(0),
  ACE(1),
  TWO(2);

  private int value;

  private Rank(int value) {
    this.value = value;
  }
}
