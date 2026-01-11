
package com.example.cactus_game.model;

public record Card(Suit suit, Rank rank) {
  public Card {}

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }
}
