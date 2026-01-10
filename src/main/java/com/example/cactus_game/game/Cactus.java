
package game;

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
