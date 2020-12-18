import BlackJack.Card;
import BlackJack.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackjackTest {
  @Test
  public void shouldRemoveCard() {

    //Given
    Deck deck = Deck.getInstance();
    int cardPlace = 1;
    Card card = deck.getDeck().get(cardPlace);
    //When
    deck.removeCard(cardPlace);

    //Then
    assertTrue(!deck.getDeck().contains(card));

  }

  @Test
  public void shouldblabla(){

  }
}
