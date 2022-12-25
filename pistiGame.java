
import java.util.Random;
import java.util.Scanner;

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
    public void playGame() {
        shuffleDeck();
        cut(); // cut the deck before dealing the cards

        dealBoard(); // deal 4 cards to the board

        for (int i = 0; i < 6; i++) {
            dealCards(); // deal 4 cards to each player
            for (int j = 0; j < 4; j++) {
                printUserHand();
                // display the last card on the board to the players
                if (boardSize != 0) {
                    System.out.println("The last card on the board is: " + board[boardSize - 1]);
                } else {
                    System.out.println("Board is empty");
                }
                userCardPlay();
                computerCardPlay();
            }
        }
        gameFinished();
    }
    public void userCardPlay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a card index to play:");
        int selectedCard = sc.nextInt();
        System.out.println("You played " + userHand[selectedCard]);
        playCard(userHand[selectedCard], true);  // ı will create playCard func to play all game
        for (int i = selectedCard; i < userHandSize - 1; i++) {
            userHand[i] = userHand[i + 1];
        }
        userHand[userHandSize - 1] = null;
        userHandSize--;
    }

    public void computerCardPlay() {
        boolean played = false;
        int selectedCard = 0;
        if (boardSize == 0) {
            selectedCard = 0;
            played = true;
        }
        if (played == false) {
            for (int i = 0; i < computerHandSize; i++) {
                if (computerHand[i].getRanks().equals(board[boardSize - 1].getRanks())) {
                    selectedCard = i;
                    played = true;
                }
            }
        }
        else if (played == false) {
            for (int i = 0; i < computerHandSize; i++) {
                if (computerHand[i].getRanks().equals("J")) {
                    selectedCard = i;
                    played = true;
                }
            }
        }
        else if (played == false) {
            selectedCard = 0;
        }
        System.out.println("Computer played " + computerHand[selectedCard]);
        playCard(computerHand[selectedCard], false); // will create a playCard func to play the game
        for (int i = selectedCard; i < computerHandSize - 1; i++) {
            computerHand[i] = computerHand[i + 1];
        }
        computerHand[computerHandSize - 1] = null;
        computerHandSize--;
    }










    // Print the user's hand
    public void printUserHand() {
        System.out.println("Your hand: ");
        for (int i = 0; i < userHand.length; i++) {
            if (userHand[i] != null)
                System.out.println(i + ": " + userHand[i]);
        }

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
    public int getCardsUsed() {
        return cardsUsed;
    }

    public void setCardsUsed(int cardsUsed) {
        this.cardsUsed = cardsUsed;
    }

    public Structure[] getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(Structure[] deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public Structure[] getUserHand() {
        return userHand;
    }

    public void setUserHand(Structure[] userHand) {
        this.userHand = userHand;
    }

    public Structure[] getComputerHand() {
        return computerHand;
    }

    public void setComputerHand(Structure[] computerHand) {
        this.computerHand = computerHand;
    }

    public Structure[] getBoard() {
        return board;
    }

    public void setBoard(Structure[] board) {
        this.board = board;
    }

    public Structure[] getUserTaken() {
        return userTaken;
    }

    public void setUserTaken(Structure[] userTaken) {
        this.userTaken = userTaken;
    }

    public Structure[] getComputerTaken() {
        return computerTaken;
    }

    public void setComputerTaken(Structure[] computerTaken) {
        this.computerTaken = computerTaken;
    }

    public int getUserTakenSize() {
        return userTakenSize;
    }

    public void setUserTakenSize(int userTakenSize) {
        this.userTakenSize = userTakenSize;
    }

    public int getComputerTakenSize() {
        return computerTakenSize;
    }

    public void setComputerTakenSize(int computerTakenSize) {
        this.computerTakenSize = computerTakenSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getUserHandSize() {
        return userHandSize;
    }

    public void setUserHandSize(int userHandSize) {
        this.userHandSize = userHandSize;
    }

    public int getComputerHandSize() {
        return computerHandSize;
    }

    public void setComputerHandSize(int computerHandSize) {
        this.computerHandSize = computerHandSize;
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



}








