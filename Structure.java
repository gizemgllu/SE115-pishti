public class Structure {
    private String numbers;
    private String letters;

    private int cardScore;

    public Structure(String numbers, String letters) {
        this.numbers= numbers;
        this.letters=letters;
    }
    public String getNumbers() {
        return this.numbers;
    }
    public String getLetters() {
        return this.letters;
    }

    public int getCardScore() {
        return this.cardScore;
    }
    public void setCardScore(int cardScore) {

        this.cardScore=cardScore;
    }

    public String toString() {
        return letters+ "-" +numbers;
    }

}
