
package com.example.cactus_game.game;

/**
 *
 */
public class Cactus implements Game {
  /**
   *
   */
  private int numPlayers;

  /**
   *
   */
  public Cactus(int numPlayers) {
    this.numPlayers = numPlayers;
  }

  public Cactus() {
    this.numPlayers = 2;
  }

  /**
   *
   */
  @Override
  public void start() {}

  @Override
  public void playRound() {}

  @Override
  public void playTurn(String playerInput) {}
}
