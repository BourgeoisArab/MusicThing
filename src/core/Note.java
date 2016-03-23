package core;

public class Note {

	/**
	 * Relative note value to the key (0 - 11) in semitones
	 */
	private int pitch;

	/**
	 * Duration, relative to that of a semi-breve <br>
	 * eg. crotchet = 1/4, minim = 1/2
	 */
	private float duration;

	public Note(int pitch, float duration) {
		if (pitch < 0 || pitch > 6 || duration < 0) {
			throw new IllegalArgumentException();
		}
		this.pitch = pitch;
		this.duration = duration;
	}

	// A get method for all properties.
	public Object[] getList() {
		return new Object[]{pitch, duration};
	}

	public float getDuration() {
		return duration;
	}

	public Note setDuration(float duration) {
		this.duration = duration;
		return this;
	}

	public int getPitch() {
		return pitch;
	}

	public Note setPitch(int pitch) {
		this.pitch = pitch;
		return this;
	}
}
