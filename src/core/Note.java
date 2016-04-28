package core;

public class Note {

	/**
	 * Relative note value to the key in semitones (+/- 60-ish with 0 at middle tonic)
	 */
	public byte pitch;

	/**
	 * Duration, relative to that of a semi-breve <br>
	 * eg. crotchet = 1/4, minim = 1/2
	 */
	public float duration;

	/**
	 * Note dynamic (0 = quiet)
	 */
	public byte velocity;

	public Note(int pitch, float duration, int velocity) {
            if (duration < 0 || velocity < 0 || velocity > 127) {
                throw new IllegalArgumentException();
            }
            this.pitch = (byte) pitch;
            this.duration = duration;
            this.velocity = (byte) velocity;
	}

	public Note(int pitch, int octave, float duration, int velocity) {
            this(pitch + octave * Key.semitones, duration, velocity);
	}

	public Note(int pitch, int octave, float duration, Dynamics d) {
            this(pitch, octave, duration, d.value);
	}

	public Note(int pitch, float duration, Dynamics d) {
            this(pitch, duration, d.value);
	}

	// A get method for all properties.
	public Object[] getList() {
            return new Object[]{pitch, duration, velocity};
	}

	public int getAbsPitch(Key k) {
            return k.getAbsPitch(pitch);
	}

	public Note copy() {
            return new Note(pitch, duration, velocity);
	}
}
