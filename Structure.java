public class Structure {
    private String numbers;
    private String letters;
    private int cardsScore;

    public Structure(String numbers, String letters) {
        this.numbers= numbers;
        this.letters=letters;
    }
    public Structure(int cardsScore) {
        this.cardsScore=cardsScore;
    }
    public String getNumbers() {

        return this.numbers;
    }
    public String getLetters() {

        return this.letters;
    }
    public int getCardsScore() {

        return this.cardsScore;
    }

    public void setLetters(int cardsScore) {

        this.cardsScore = cardsScore;
    }

    public String toString() {

        return letters+ "-" +numbers;
    }

}
