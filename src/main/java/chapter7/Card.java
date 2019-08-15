package chapter7;

class Card {

    private Suit suit;

    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }

        Card cardObj = (Card) obj;
        return cardObj.getRank() == getRank() && cardObj.getSuit() == getSuit();
    }
}
