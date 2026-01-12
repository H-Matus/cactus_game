
package com.example.cactus_game.game;

import com.example.cactus_game.model.CactusDeck;
import com.example.cactus_game.model.CactusHand;
import com.example.cactus_game.model.Card;

/**
 *
 */
public class Cactus implements Game {
  public static final int MIN_NUM_PLAYERS = 2;
  public static final int MAX_NUM_PLAYERS = 4;

  private CactusDeck deck;

  private CactusDeck discardDeck;

  private CactusHand[] hands;

  private int numPlayers;

  private boolean finished;

  private boolean cactusCalled;

  private int callerIdx;

  private int remainingTurns;

  public Cactus(int numPlayers) {
    this.deck = new CactusDeck();
    this.discardDeck = new CactusDeck();
    this.hands = new CactusHand[numPlayers];
    this.numPlayers = numPlayers;
    this.finished = false;
    this.cactusCalled = false;
    this.callerIdx = 0;
    this.remainingTurns = 0;
  }

  /**
   *
   */
  @Override
  public void setup() {
    this.deck.fillDeck();

    this.fillHands();
  }

  public Card readDiscardDeckTopCard() {
    return this.discardDeck.readTopCard();
  }

  public Card drawDeckCard() {
    return this.deck.drawCard();
  }

  public Card drawDiscardDeckCard() {
    return this.discardDeck.drawCard();
  }

  @Override
  public void playTurn(Card card) {
    if (this.cactusCalled == true) {
      this.remainingTurns--;
    }

    if (this.cactusCalled == true && this.remainingTurns == 0) {
      this.finished = true;
    } else {
      this.discardDeck.addCard(card);
    }
  }

  @Override
  public void playTurn(int playerIdx, int cardIdx, String deck, String action, Card pickedCard) {
    if (this.cactusCalled == true) {
      this.remainingTurns--;
    }

    if (this.cactusCalled == true && this.remainingTurns == 0) {
      this.finished = true;
    } else {
      if (deck.toLowerCase().equals("main")) {
        /* Main deck, action replace */
        this.discardDeck.addCard(this.hands[playerIdx].getCard(cardIdx));
        this.hands[playerIdx].addCard(pickedCard, cardIdx);
      } else if (deck.toLowerCase().equals("discard")) {
        /* Discard deck, action replace */
        Card topDiscardedCard = pickedCard;
        this.discardDeck.addCard(this.hands[playerIdx].getCard(cardIdx));
        this.hands[playerIdx].addCard(topDiscardedCard, cardIdx);
      }
    }
  }

  @Override
  public void callCactus(int playerIdx, String cactusCallInput) {
    if (cactusCallInput.equals("Yes")) {
      this.cactusCalled = true;
      this.remainingTurns = this.numPlayers - 1;
      this.callerIdx = playerIdx;
    }
  }

  @Override
  public int getDiscardDeckSize() {
    return this.discardDeck.getSize();
  }

  @Override
  public int getWinner() {
    int[] handValues = new int[numPlayers];
    for (int playerIdx = 0; playerIdx < numPlayers; playerIdx++) {
      for (int cardIdx = 0; cardIdx < CactusHand.HAND_SIZE; cardIdx++) {
        handValues[playerIdx] += this.hands[playerIdx].getCard(cardIdx).getRank().getValue();
      }
    }
    return this.findMinIdx(handValues);
  }

  @Override
  public boolean isFinished() {
    return this.finished;
  }

  @Override
  public boolean isCactusCalled() {
    return this.cactusCalled;
  }

  private void fillHands() {
    for (int playerIdx = 0; playerIdx < this.numPlayers; playerIdx++) {
      Card tempCards[] = new Card[CactusHand.HAND_SIZE];

      for (int cardIdx = 0; cardIdx < CactusHand.HAND_SIZE; cardIdx++) {
        tempCards[cardIdx] = this.deck.drawCard();
      }

      this.hands[playerIdx] = new CactusHand(tempCards);
    }
  }

  /**
   * Utility function to find a minimum element's index in a given array.
   * Used in finding the winner of the cactus game.
   * @return int Index of a minimum value in a given array.
   */
  private int findMinIdx(int[] array) {
    int minIdx = 0;
    int min = array[minIdx];
    for (int i = 0; i < array.length; i++) {
      if (min > array[i]) {
        minIdx = i;
        min = array[i];
      }
    }
    return minIdx;
  }
}
