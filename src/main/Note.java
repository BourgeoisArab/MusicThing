package main;

public class Note {

	/**
	 * Relative note value to the key (0 - 6)
	 */
	private int pitch;

	/**
	 * Absolute frequency
	 */
	private float freq;

	/**
	 * Duration, relative to that of a semi-breve <br>
	 * eg. crotchet = 1/4, minim = 1/2
	 */
	private float duration;

	public Note(int pitch, float freq, float duration) {
		if (pitch < 0 || pitch > 6 || freq < 0 || duration < 0) {
			throw new IllegalArgumentException();
		}
		this.pitch = pitch;
		this.freq = freq;
		this.duration = duration;
	}

	public float getFrequency() {
		return freq;
	}

	public float getDuration() {
		return duration;
	}

	public Note setFrequency(float freq) {
		this.freq = freq;
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
