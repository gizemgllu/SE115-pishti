public class Structure {
    private String ranks;
    private String suits;
    private int cardsScore;

    public Structure(String ranks, String suits) {
        this.ranks = ranks;
        this.suits = suits;

        if (ranks.equals("2") && suits.equals("♣")) {
            this.cardsScore = 2;
        } else if (ranks.equals("10") && suits.equals("♥")) {
            this.cardsScore = 3;
        } else {
            this.cardsScore = 1;
        }
    }

    public Structure(int cardsScore) {
        this.cardsScore = cardsScore;
    }

    public String getRanks() {
        return this.ranks;
    }

    public String getSuits() {
        return this.suits;
    }

    public int getCardsScore() {
        return this.cardsScore;
    }

    public String toString() {
        return suits + ranks;
    }

}