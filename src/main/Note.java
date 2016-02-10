package main;

public class Note {

	private float freq;
	private float duration;

	public Note(float freq, float duration) {
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

}
