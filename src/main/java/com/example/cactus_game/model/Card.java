
package com.example.cactus_game.model;

import com.example.cactus_game.model.Rank;
import com.example.cactus_game.model.Suit;

public record Card(Suit suit, Rank rank) {
  public Card {}

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }
}
