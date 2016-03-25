package core;

public class Key {

    /**
     * Array storing all the keys, starting with C major
     */
    public static Key[] keys_major = new Key[12];

    static {
        // Populates array with all major keys
        for (int i = 0; i < keys_major.length; i++) {
            // keys_major[i] = new Key(440F * (float) Math.pow(2, (i - 9) / 12F), true);
            keys_major[i] = new Key(0x3C + i, true);
        }
    }

    /**
     * The absolute frequency of middle octave tonic
     */
    public final int tonic;

    /**
     * Major or minor key
     */
    private boolean major;

    /**
     * Stores semitone values, relative to tonic (0) Index of this is a relative note on the scale
     */
    public final int[] tones;

    public Key(int tonic, boolean major) {
        this.tonic = tonic;
        this.major = major;
        if (major) {
            tones = new int[]{0, 2, 4, 5, 7, 9, 11};
        } else {
            tones = new int[]{0, 2, 3, 5, 7, 8, 11};
        }
    }

    public int getAbsolutePitch(int note, int octave) {
        return tonic + note + octave * 12;
    }

    public static Note flat(Note note) {
        return note.setPitch(note.getPitch() - 1);
    }

    public static Note sharp(Note note) {
        return note.setPitch(note.getPitch() + 1);
    }

}
