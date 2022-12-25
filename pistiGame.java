import java.util.Arrays;
import java.util.Random;

public class pistiGame {
    private final String[] suits = {"♥", "♦", "♠", "♣" };
    private static final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
    private static final int numbCards = 52;
    private int cardsUsed;
    private Structure[] deckOfCards;
    private Structure[] userHand;
    private Structure[] computerHand;
    private Structure[] board;
    private Structure[] userTaken;
    private Structure[] computerTaken;
    private int userTakenSize;
    private int computerTakenSize;
    private int boardSize;
    private int userHandSize;
    private int computerHandSize;
    private static int userScore;
    private static int computerScore;
    private boolean userTake;


    public pistiGame() {
        deckOfCards = new Structure[numbCards];
        board = new Structure[numbCards];
        userHand = new Structure[4];
        computerHand = new Structure[4];
        userTaken = new Structure[numbCards];
        computerTaken = new Structure[numbCards];
        boardSize = 0;
        userHandSize = 0;
        computerHandSize = 0;
        userTakenSize = 0;
        computerTakenSize = 0;
        userScore = 0;
        computerScore = 0;
        cardsUsed = 0;
        userTake = false;
        createDeck();
    }



    public void createDeck() {
        for (int i = 0; i < numbCards; i++) {
            deckOfCards[i] = new Structure(ranks[i % 13], suits[i / 13]);
        }
    }

    public void shuffleDeck() {
        for (int i = 0; i < deckOfCards.length; i++) {
            int j = (int) (Math.random() * deckOfCards.length);
            Structure tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
        }
    }


    public void setBoard() {
        this.board=board;
    }



    public void cut() {
        int cutPoint = (int) (Math.random() * numbCards);
        Structure top[] = new Structure[cutPoint];
        Structure bottom[] = new Structure[deckOfCards.length - cutPoint];
        for (int i = 0; i < numbCards; i++) {
            if (i < cutPoint) {
                top[i] = deckOfCards[i];
            } else {
                bottom[i - cutPoint] = deckOfCards[i];
            }
        }
        for (int i = 0; i < deckOfCards.length; i++) {
            if (i < (numbCards - cutPoint)) {
                deckOfCards[i] = bottom[i];
            } else {
                deckOfCards[i] = top[i - (numbCards - cutPoint)];
            }
        }
    }

    public void dealCards() {
        for (int i = 0; i < 4; i++) {
            userHand[i] = deckOfCards[i + cardsUsed];
        }
        cardsUsed += 4;
        userHandSize = 4;
        for (int i = 0; i < 4; i++) {
            computerHand[i] = deckOfCards[i + cardsUsed];
        }
        cardsUsed += 4;
        computerHandSize = 4;
    }

    public void dealBoard() {
        for (int i = 0; i < 4; i++) {
            board[i] = deckOfCards[i + cardsUsed];
        }
        cardsUsed += 4;
        boardSize = 4;
    }

    public void printUserHand() {
        System.out.println("Your hand: ");
        for (Structure card : this.userHand) {
            System.out.println(card);
        }
    }


    public static void gameFinished() {
        System.out.println("_________________________");
        System.out.println("Game Finished");
        System.out.println("Result: ");
        System.out.println("Computer Score = " + computerScore);
        System.out.println("Your Score = " + userScore);

        if (userScore < computerScore)
            System.out.println("Computer Wins!");
        else if (computerScore < userScore)
            System.out.println("You Wins!");
        else
            System.out.println("Nobody won! Your score and computer score are equal :)");

        System.out.println("Thanks for playing.");
        System.out.println("-------------------------");
    }
    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

}








