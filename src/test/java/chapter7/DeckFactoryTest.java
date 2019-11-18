package chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class DeckFactoryTest {

    private static DeckFactory deckFactory;

    @BeforeAll
    static void setup() {
        deckFactory = new DeckFactory();
    }

    @Test
    void testThatDeckHas52Cards() {
        LinkedList<Card> deck = deckFactory.createShuffledDeck();
        Assertions.assertEquals(52, deck.size());
    }

    @Test
    void testThatAllCardsAreInDeck() {
        LinkedList<Card> deck = deckFactory.createShuffledDeck();
        LinkedList<Card> possibleCards = new LinkedList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                possibleCards.add(new Card(suit, rank));
            }
        }

        for (Card possibleCard : possibleCards) {
            boolean cardFound = deck.remove(possibleCard);
            Assertions.assertTrue(cardFound);
        }
    }
}
