package core;

public enum Cadence {
    perfect(4, 0),
    plagal(3, 0),
    imperfect(5),
    interrupted(5, 6);

    public final int[] chords;

    Cadence(int... chords) {
        this.chords = chords;
    }
}
