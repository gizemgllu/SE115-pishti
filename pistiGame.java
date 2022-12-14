import java.util.Random;

public class pistiGame {

    private Structure[] deckOfCards;
    private static final int numbCards = 52;
    private static int currentC;
    private int cardsUsed;
    private static final Random rndNumbers = new Random();
    private String[] cardsScore;

    public pistiGame() {
        cardsUsed=0;
        currentC = 0;
        String[] letters = {"C", "D", "H", "S"};
        String[] numbers = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10","J", "K", "Q"};
        deckOfCards = new Structure[numbCards];

        for (int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = new Structure(numbers[i % 13], letters[i / 13]);

        }
    }
    public int getNumbCards() {
        return this.numbCards;
    }
    public void shuffleCards() {

        for (int i =deckOfCards.length;i>0; i--) {
            int rndNumbers=(int)(Math.random()*(i+1));
            Structure tmp = deckOfCards[i];
            deckOfCards[i]=deckOfCards[rndNumbers];
            deckOfCards[rndNumbers]=tmp;
        }
             cardsUsed=  0;
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
    public int cardsLeft(){

        return deckOfCards.length-cardsUsed;
    }
    public Structure dealingCards() {
        if(currentC< deckOfCards.length) {
            return deckOfCards[cardsUsed++];
        }
        else{
            return null;
        }
        public void cut(){
            Random r= new Random();
            int cutPosition=r.nextInt(numbCards);
            String[] newCards= new String[numbCards];
            for(int i=0; i<numbCards;i++) {
                newCards[i]=cardsScore[(cutPosition+i)%numbCards];
            }


        }
    }

}
