
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

  public Cactus(int numPlayers) {
    this.deck = new CactusDeck();
    this.discardDeck = new CactusDeck();
    this.hands = new CactusHand[numPlayers];
    this.numPlayers = numPlayers;
  }

  /**
   *
   */
  @Override
  public void setup() {
    this.deck.fillDeck();

    this.fillHands();
  }

  @Override
  public void playRound() {}

  @Override
  public void playTurn(String playerInput) {}

  private void fillHands() {
    for (int playerIdx = 0; playerIdx < this.numPlayers; playerIdx++) {
      Card tempCards[] = new Card[CactusHand.HAND_SIZE];

      for (int cardIdx = 0; cardIdx < CactusHand.HAND_SIZE; cardIdx++) {
        tempCards[cardIdx] = this.deck.drawCard();
      }

      this.hands[playerIdx] = new CactusHand(tempCards);
    }
  }
}
