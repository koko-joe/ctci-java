package chapter7;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
Chapter 7
Question 1

Black Jack Game.
Assumptions:
- 52 cards in a deck
- there is only 1 player
- either you have 21 and you win, or you have more than 21 and you lose
- an ace has a value of 11 by itself, if it's combined with other cards which have a value over 10 the ace has a value of 1
- if you have more than 1 ace, 1 ace has the value of 11, the other aces have the value 1
 */
public class BlackJackGame {

    private DeckFactory deckFactory;

    private static final int WIN_SCORE = 21;

    private static final char START_GAME_COMMAND = 's';

    private static final char DRAW_CARD_COMMAND = 'd';

    public BlackJackGame(DeckFactory deckFactory) {
        this.deckFactory = deckFactory;
    }

    public void startGame() throws IOException {
        System.out.println("Do you want to play?");
        boolean continueGame = confirmRestart();
        while (continueGame) {
            LinkedList<Card> deck = deckFactory.createShuffledDeck();
            LinkedList<Card> hand = new LinkedList<Card>();
            while (true) {
                final int currentScore = getScore(hand);
                System.out.println("Your current score is: " + currentScore);

                if (currentScore == WIN_SCORE) {
                    System.out.println("You won.");
                    continueGame = confirmRestart();
                    break;
                }

                if (currentScore > WIN_SCORE) {
                    System.out.println("You lost.");
                    continueGame = confirmRestart();
                    break;
                }

                System.out.println("Press " + DRAW_CARD_COMMAND + " to draw a card or any other key to don't draw a card.");
                int input = System.in.read();
                if (Character.toLowerCase(input) == DRAW_CARD_COMMAND) {
                    draw(deck, hand);
                    continue;
                }

                continueGame = confirmRestart();
                if (! continueGame) {
                    break;
                }
            }
        }
    }

    private boolean confirmRestart() throws IOException {
        System.out.println("Press " + START_GAME_COMMAND +  " to start a new game or any other key to quit.");
        int input = System.in.read();
        return Character.toLowerCase(input) == START_GAME_COMMAND;
    }

    private void draw(LinkedList<Card> deck, LinkedList<Card> hand) {
        Card card = deck.remove();
        hand.add(card);
    }

    private int getScore(List<Card> hand) {
        int aceCount = 0;
        int score = 0;

        for (Card card : hand) {
            final Rank rank = card.getRank();
            if (rank == Rank.ACE) {
                ++aceCount;
                continue;
            }

            score += rank.getValue();
        }

        if (aceCount == 0) {
            return score;
        }

        if (aceCount == 1) {
            int aceValue = Rank.ACE.getValue();
            if (score > 10) {
                aceValue = Rank.ACE.getSpecialValue();
            }

            return score + aceValue;
        }

        if (aceCount > 1) {
            return score + Rank.ACE.getValue() + ((aceCount - 1) * Rank.ACE.getSpecialValue());

        }

        return score;
    }
}
