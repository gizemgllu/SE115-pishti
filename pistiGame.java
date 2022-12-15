import java.util.Random;
import java.util.Scanner;

public class pistiGame {

    private Structure[] deckOfCards;
    private static final int numbCards = 52;
    private static int currentC;
    private int cardsUsed;
    private static final Random rndNumbers = new Random();
    private String[] cardsScore;

    public pistiGame() {
        cardsUsed = 0;
        currentC = 0;
        String[] letters = {"C", "D", "H", "S"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
        deckOfCards = new Structure[numbCards];

        for (int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = new Structure(numbers[i % 13], letters[i / 13]);


        }
    }

    public void setDeckOfCards() {
        this.deckOfCards = deckOfCards;
    }

    public int getNumbCards() {

        return this.numbCards;
    }


    public Structure giveCard(int numbCards) {
        numbCards--;
        cardsUsed++;
        System.out.println("Number of cards left: " + cardsLeft());
        return deckOfCards[numbCards];
    }

    public Structure showCard(int numbCards) {

        return deckOfCards[numbCards];
    }

    public int cardsLeft() {

        return deckOfCards.length - cardsUsed;
    }

    public Structure dealingCards() {
        if (currentC < deckOfCards.length) {
            return deckOfCards[cardsUsed++];
        } else {
            return null;
        }
    }

    public void cut() {
        Random r = new Random();
        int cutPosition = r.nextInt(numbCards);
        String[] newCards = new String[numbCards];
        for (int i = 0; i < numbCards; i++) {
            newCards[i] = cardsScore[(cutPosition + i) % numbCards];
        }
    }

    public void shuflleCards() {

        for (int i = deckOfCards.length - 1; i > 0; i--) {
            int rndNumbers = (int) (Math.random() * (i + 1));
            Structure tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[rndNumbers];
            deckOfCards[rndNumbers] = tmp;
            System.out.println(deckOfCards[rndNumbers]);
        }
        cardsUsed = 0;
    }

    public static void cut(String [] deck) {
        System.out.println("Who cut the deck user 1,computer 2 ");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("pick number");
            int a = sc.nextInt();

            String[] deck2 = new String[52];
            String[] deck3 = new String[52];
            System.arraycopy(deck, 0, deck2, 0, a);
            System.arraycopy(deck, 0, deck3, 52 - a, 52);

        }
        if(answer==2) {
            Random r= new Random();
            int comp=r.nextInt(52);
            String[] deck2 = new String[52];
            String[] deck3 = new String[52];
            System.arraycopy(deck, 0, deck2, 0, comp);
            System.arraycopy(deck, 0, deck3, 52 - comp, 52);

        }
    }
}