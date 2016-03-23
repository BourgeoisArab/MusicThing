package core;

public class Note {

	/**
	 * Relative note value to the key (0 - 6)
	 */
	private int pitch;

	/**
	 * Absolute frequency
	 */
	private float frequency;

	/**
	 * Duration, relative to that of a semi-breve <br>
	 * eg. crotchet = 1/4, minim = 1/2
	 */
	private float duration;

	public Note(int pitch, float frequency, float duration) {
		if (pitch < 0 || pitch > 6 || frequency < 0 || duration < 0) {
			throw new IllegalArgumentException();
		}
		this.pitch = pitch;
		this.frequency = frequency;
		this.duration = duration;
	}

	// A get method for all properties.
	public Object[] getList() {
		return new Object[]{pitch, frequency, duration};
	}

	public float getFrequency() {
		return frequency;
	}

	public float getDuration() {
		return duration;
	}

	public Note setFrequency(float frequency) {
		this.frequency = frequency;
		return this;
	}

	public Note setDuration(float duration) {
		this.duration = duration;
		return this;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
}
