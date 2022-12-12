public class Structure {
    private String numbers;
    private String letters;

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

    public String toString() {
        return letters+ "-" +numbers;
    }

}
