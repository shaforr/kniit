public enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String nameRus;

    Suit(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNameRus() {
        return nameRus;
    }
}
