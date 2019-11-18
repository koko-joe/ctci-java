package chapter7;

import java.util.Collections;
import java.util.LinkedList;

class DeckFactory {

    LinkedList<Card> createShuffledDeck() {
        LinkedList<Card> deck = new LinkedList<>();
        for (Suit suit:Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }
}
