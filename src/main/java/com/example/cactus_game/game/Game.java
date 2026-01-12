
package com.example.cactus_game.game;

import com.example.cactus_game.model.Card;

/**
 *
 */
public interface Game {
  /**
   *
   */
  void setup();

  /**
   *
   */
  void playTurn(Card card);

  /**
   *
   */
  void playTurn(int playerIdx, int cardIdx, String deck, String action, Card card);

  /**
   *
   */
  void callCactus(int playerIdx, String cactusCallInput);

  /**
   *
   */
  int getDiscardDeckSize();

  /**
   *
   */
  int getWinner();

  /**
   *
   */
  boolean isFinished();

  /**
   *
   */
  boolean isCactusCalled();
}
