import java.util.Random;

public class pistiGame {
    private final String[] suits = {"hearts", "diamonds", "spades", "clubs"};
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
    private static final int numbCards = 52;
    private static int currentC;
    private static int cardsUsed;
    private static final Random rndNumbers = new Random();
    private String[] cardsScore;
    static String[] deckOfCards = new String[numbCards];


    public void shuffleDeck() {

        for (int i = 0; i < numbCards; i++) {
            deckOfCards[i] = ranks[i % 13] + " of " + suits[i / 13];
            System.out.println(deckOfCards[i]);
        }

        System.out.println("----------------");

        for (int i = 0; i < deckOfCards.length; i++) {
            int index = (int) (Math.random() * deckOfCards.length);
            String tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[index];
            deckOfCards[index] = tmp;

        }
        for (String u : deckOfCards) {
            System.out.println(u);
        }

        cardsUsed = 0;

    }

    public void setDeckOfCards() {
        this.deckOfCards = deckOfCards;
    }

    public String[] getDeckOfCards() {
        return this.deckOfCards;
    }

    public String[] cutDeck(String[] deckOfCards, int cutPoint) {
        String[] topHalf = new String[cutPoint];
        String[] bottomHalf = new String[deckOfCards.length - cutPoint];

        // Cut the deckOfCards at the chosen point
        for (int i = 0; i < cutPoint; i++) {
            topHalf[i] = deckOfCards[i];
        }
        for (int i = cutPoint; i < deckOfCards.length; i++) {
            bottomHalf[i - cutPoint] = deckOfCards[i];
        }

        if (cutPoint < deckOfCards.length / 2) {
            return topHalf;
        } else {
            return bottomHalf;
        }

    }

    public int getNumbCards() {

        return this.numbCards;
    }


    public String giveCard(int numbCards) {
        numbCards--;
        cardsUsed++;
        System.out.println("Number of cards left: " + cardsLeft());
        return deckOfCards[numbCards];
    }

    public String showCard(int numbCards) {

        return deckOfCards[numbCards];
    }

    public int cardsLeft() {

        return deckOfCards.length - cardsUsed;
    }

    public String dealingCards() {
        if (currentC < deckOfCards.length) {
            return deckOfCards[cardsUsed++];
        } else {
            return null;
        }
    }


}






