import java.util.Arrays;
import java.util.Random;

public class pistiGame {
    private final String[] suits = {"hearts", "diamonds", "spades", "clubs"};
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
    private static final int numbCards = 52;
    private static int cardsUsed;
    private static final Random rndNumbers = new Random();
    private String[] cardsScore;
    private int[] scores;
    private static String[] deckOfCards = new String[numbCards];
    private Structure[] userHand;
    private Structure[] computerHand;
    private Structure[] board;
    private int boardSize;
    private int userHandSize;
    private int computerHandSize;


    static int yourScore = 0;
    static int computerScore = 0;
    private int index;



    public void shuffleDeck() {

        for (int i = 0; i < numbCards; i++) {
            int index = 0;
            deckOfCards[i] = ranks[i % 13] + " of " + suits[i / 13];
            System.out.println(deckOfCards[i]);
            deckOfCards[index] = Arrays.toString(getDeckOfCards(suits, ranks));
            index++;
        }
        this.index=0;

        System.out.println("----------------");

        for (int i = 0; i < deckOfCards.length; i++) {
            int j = (int) (Math.random() * deckOfCards.length);
            String tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;

        }
        for (String u : deckOfCards) {
            System.out.println(u);
        }

        cardsUsed = 0;

    }

    public void setDeckOfCards() {

        this.deckOfCards = deckOfCards;
    }

    public void setBoard() {
        this.board=board;
    }

    public String[] getDeckOfCards(String[] suits, String[] ranks) {

        return this.deckOfCards;
    }
    public void Card() {
        // Initialize the instance variables
        board = new Structure[52];
        userHand = new Structure[52];
        computerHand = new Structure[52];
        scores = new int[2];
        boardSize = 0;
        userHandSize = 0;
        computerHandSize=0;
    }

    public void cut() {
        Random rd = new Random();
        int cutPoint = rd.nextInt(deckOfCards.length);
        String top[] = new String[cutPoint];
        String bottom[] = new String[deckOfCards.length - cutPoint];
        System.arraycopy(deckOfCards, 0, top, 0, cutPoint);
        System.arraycopy(deckOfCards, cutPoint, bottom, 0, deckOfCards.length - cutPoint);
        String[] newArray = new String[top.length + bottom.length];
        System.arraycopy(bottom, 0, newArray, 0, bottom.length);
        System.arraycopy(top, 0, newArray, bottom.length, top.length);


        for (String card : top) {
            System.out.println("-" + card);
        }
        for (String cards : bottom) {
            System.out.println("+" +cards);
        }
        for (String cardd : newArray) {
            System.out.println("!" +cardd);
        }

    }

    public String[][] dealCards() {
        int index=0;
        String[][] userHand = new String[2][4];
        for (int i = 0; i < 4; i++) {
            userHand[0][i] = deckOfCards[index];
            index++;
            userHand[1][i] = deckOfCards[index];
            index++;
        }
        return userHand;
    }

    public String[] dealBoard() {
        int index=0;
        String[] board = new String[4];
        for (int i = 0; i < 4; i++) {
            board[i] = deckOfCards[index];
            index++;
        }
        return board;
    }


    public void playGame() {

        cut(); // cut the deck before dealing the cards

        String[][] hands = dealCards(); // deal 4 cards to each player
        String[] board = dealBoard(); // deal 4 cards to the board
        printUserHand();

        // display the last card on the board to the players
        System.out.println("The last card on the board is: " + board[board.length - 1]);
    }
        // Print the user's hand

    public void printUserHand() {
        System.out.println("Your hand: ");
        for (Structure card : this.userHand) {
            System.out.println(card);
        }
    }





    public String giveCard(int numbCards) {
        numbCards--;
        cardsUsed++;
        System.out.println("Number of cards left: " + cardsLeft());
        return deckOfCards[numbCards];
    }

    public int cardsLeft() {

        return deckOfCards.length - cardsUsed;
    }


    public static void gameFinished() {
        System.out.println("_________________________");
        System.out.println("Game Finished");
        System.out.println("Result: ");
        System.out.println("Computer Score = " + computerScore);
        System.out.println("Your Score = " + yourScore);

        if (yourScore < computerScore)
            System.out.println("Computer Wins!");
        else if (computerScore < yourScore)
            System.out.println("You Wins!");
        else
            System.out.println("Nobody won! Your score and computer score are equal :)");

        System.out.println("Thanks for playing.");
        System.out.println("-------------------------");
    }


}






