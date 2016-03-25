package core;

public class Note {

    /**
     * Relative note value to the key (0 - 11) in semitones
     */
    private byte pitch;

    /**
     * Duration, relative to that of a semi-breve <br>
     * eg. crotchet = 1/4, minim = 1/2
     */
    private float duration;

    /**
     * Note dynamic (0 = quiet)
     */
    private byte velocity;

    public Note(int pitch, float duration, int velocity) {
        if (pitch < 0 || pitch > 11 || duration < 0 || velocity < 0 || velocity > 127) {
            throw new IllegalArgumentException();
        }
        this.pitch = (byte) pitch;
        this.duration = duration;
        this.velocity = (byte) velocity;
    }

    public Note(int pitch, float duration, Dynamics d) {
        this(pitch, duration, d.value);
    }

    // A get method for all properties.
    public Object[] getList() {
        return new Object[]{pitch, duration, velocity};
    }

    public float getDuration() {
        return duration;
    }

    public Note setDuration(float duration) {
        this.duration = duration;
        return this;
    }

    public byte getPitch() {
        return pitch;
    }

    public Note setPitch(int pitch) {
        this.pitch = (byte) pitch;
        return this;
    }

    public byte getVelocity() {
        return pitch;
    }

    public Note setVelocity(int velocity) {
        this.velocity = (byte) velocity;
        return this;
    }
}
