
package com.example.cactus_game.model;

import com.example.cactus_game.util.RandomShuffler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CactusDeck implements Deck {
  private ArrayDeque<Card> cards = new ArrayDeque<Card>();
  private RandomShuffler shuffler = new RandomShuffler();

  public CactusDeck() {}

  @Override
  public void fillDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        if (rank != Rank.JOKER) {
          this.cards.add(new Card(suit, rank));
        }
      }
    }
    this.shuffle();
  }

  @Override
  public Card drawCard() {
    return this.cards.removeFirst();
  }

  @Override
  public void addCard(Card card) {
    this.cards.addFirst(card);
  }

  @Override
  public void shuffle() {
    List<Card> tempDeck = new ArrayList<>(this.cards);
    this.shuffler.shuffle(tempDeck);
    this.cards.clear();
    this.cards.addAll(tempDeck);
  }

  /**
   * Overriden toString function used for testing the deck.
   * @return String of all cards in the deck.
   */
  @Override
  public String toString() {
    String ret = "";

    for (Card card : this.cards) {
      ret += "Card: " + card.getRank() + " of " + card.getSuit() + "\n";
    }

    return ret;
  }
}
