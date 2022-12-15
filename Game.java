import java.util.Scanner;
import java.util.Random;
public class Game {
    public static void main(String[] args) {

        System.out.println("Welcome the Turkish Pishti Game!:)");
        pistiGame pistiGame1= new pistiGame();
        pistiGame1.shuffleDeck();

        Scanner sc = new Scanner(System.in);

        String[] deck = new String[pistiGame1.getNumbCards()];

        System.out.println("Do you want to pick a number (1) or have the computer pick a number (2)?");
        int choice = sc.nextInt();

        // Pick a number
        int cutPoint;
        if (choice == 1) {
            System.out.println("Enter a number between 0 and 51:");
            cutPoint = sc.nextInt();
        } else {
            Random rand = new Random();
            cutPoint = rand.nextInt(pistiGame1.getNumbCards());
        }

        // Cut the deck at the chosen point
        String[] topHalf = cutDeck(deck, cutPoint);
        String[] bottomHalf = cutDeck(deck, pistiGame1.getNumbCards() - cutPoint);

        // Print the top and bottom halves of the deck
        System.out.println("Top half of the deck:");
        for (String card : topHalf) {
            System.out.println(card);
        }
        System.out.println("Bottom half of the deck:");
        for (String card : bottomHalf) {
            System.out.println(card);
        }
    }

    public static String[] cutDeck(String[] deck, int cutPoint) {
        String[] half = new String[cutPoint];
        for (int i = 0; i < cutPoint; i++) {
            half[i] = deck[i];
        }
        return half;
    }
}




