
package com.example.cactus_game.model;

public record Card(Suit suit, Rank rank) {
  public Card {}

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }

  public String toString() {
    String ret = "";

    ret += this.rank + " of " + this.suit + "\n";

    return ret;
  }
}
