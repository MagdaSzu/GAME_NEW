package words;

public enum Point {
    EASY(3),MID(6),HARD(9);

    private final int value;

    Point(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }

}
