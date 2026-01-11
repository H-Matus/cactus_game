
package com.example.cactus_game.util;

import com.example.cactus_game.model.Card;
import java.util.Collections;
import java.util.List;

public class RandomShuffler implements Shuffler {
  public RandomShuffler() {}

  @Override
  public void shuffle(List<Card> cards) {
    Collections.shuffle(cards);
  }
}
