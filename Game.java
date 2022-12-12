import java.util.Scanner;
public class Game {
  public static void main(String[]args) {
      System.out.println("Welcome the Turkish Pishti Game!:)");
     Scanner sc= new Scanner(System.in);
      pistiGame pistiGame1 = new pistiGame();
      int highestScore=0;

      for(int k=0; k<52;k++) {
          System.out.println(pistiGame1.showCard(pistiGame1.getNumbCards()-1).toString());
      }


    }

}
