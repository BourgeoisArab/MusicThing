package core;

public class Key {

    /**
     * Array storing all the keys, starting with C major
     */
    public static final Key[] keys_major = new Key[12];
    public static final int semitones = 12;

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

    public int getAbsPitch(int pitch) {
        return tonic + pitch;
    }

    public static Note flat(Note note) {
        // return note.setPitch(note.getPitch() - 1);
        note.pitch -= 1;
        return note;
    }

    public static Note sharp(Note note) {
        // return note.setPitch(note.getPitch() + 1);
        note.pitch += 1;
        return note;
    }

    /**
     * @param n existing note, relative to which new one is created
     * @param interval number of semitones above or below
     * @param scale whether the interval is in semitones, or scale note values
     * @return Note
     */
    public Note getRelNote(Note n, int interval, boolean scale) {
        int i = getTechnicalName(n);
        if (!scale || i < 0 && scale) {
            if (scale) {
                System.out.println("Note " + n + " is not part of the key " + this);
            }
            return new Note(n.pitch + interval, n.duration, n.velocity);
        } else {
            int j = (i + interval) % tones.length;
            return new Note(tones[j] + semitones * ((i + interval) / tones.length + n.pitch / semitones), n.duration, n.velocity);
        }
    }

    public Note getRelNote(Note n, Interval interval, boolean scale) {
        return getRelNote(n, interval.value(), scale);
    }

    /**
     * feel free to rename this method
     * 
     * @return index of tones[] at which the note is found
     */
    public int getTechnicalName(Note n) {
        int k = n.pitch % semitones;
        for (int i = 0; i < tones.length; i++) {
            if (k == tones[i]) {
                return i;
            }
        }
        return -1;
    }

}
