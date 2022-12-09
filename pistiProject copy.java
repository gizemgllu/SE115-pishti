import java.util.Scanner;
import java.util.Random;
public class pistiProject {

    public static void main(String[]args) {
        String[] letters = {"C", "D", "H", "S"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "K", "Q"};
        String[] deckOfCards = new String[52];

        for (int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = numbers[i % 13] + letters[i / 13];
            System.out.println(deckOfCards[i]);
        }
         for(int i=0; i<deckOfCards.length;i++) {
             int j=(int)(Math.random()*deckOfCards.length);
             String tmp=deckOfCards[i];
             deckOfCards[i]=deckOfCards[j];
             deckOfCards[j]=tmp;
         }
         for(String r: deckOfCards) {
             System.out.println(r);
         }
    }

}
