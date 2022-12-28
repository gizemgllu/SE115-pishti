

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] highscores = new String[10];
        for (int i = 0; i < 10; i++) {
            highscores[i] = null;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                highscores[i] = line;
                i++;
            }
            br.close();
        } catch (IOException e) {

        }

        System.out.println("Welcome the Turkish Pishti Game!:)");
        PistiGame pistiGame1 = new PistiGame();
        pistiGame1.playGame();
        int userScore = pistiGame1.getUserScore();
        boolean write = false;
        for (int i = 0; i < 10; i++) {
            if (highscores[i] == null) {
                write = true;
            }
        }
        if (write == false) {
            for (int i = 0; i < 10; i++) {
                int score = Integer.parseInt(highscores[i].split(":")[1]);
                if (score < userScore) {
                    write = true;
                }
            }
        }
        if (write) {
            System.out.println("Congratulations, you entered the high score list, please write your name:");
            String name = sc.nextLine();
            highscores[9] = name + ":" + userScore;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    if (highscores[j] == null) {
                        String tmp = highscores[j + 1];
                        highscores[j + 1] = highscores[j];
                        highscores[j] = tmp;
                    } else {
                        int jScore = Integer.parseInt(highscores[j].split(":")[1]);
                        if (highscores[j + 1] != null) {
                            int nextScore = Integer.parseInt(highscores[j + 1].split(":")[1]);
                            if (jScore < nextScore) {
                                String tmp = highscores[j + 1];
                                highscores[j + 1] = highscores[j];
                                highscores[j] = tmp;
                            }
                        }
                    }
                }
            }
            System.out.println("HIGH SCORES");
            for (int i = 0; i < 10; i++) {
                if (highscores[i] != null) {
                    System.out.println(highscores[i]);
                }
            }
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter("highscore.txt"));
                for (int i = 0; i < 10; i++) {
                    if (highscores[i] != null) {
                        br.write(highscores[i] + "\n");
                    }
                }
                br.close();
            } catch (IOException e) {

            }
        }
    }
}
