package core;

public class PNote extends Note {

	protected int[] time = null;
	protected Key key = null;
	protected int tempo = 0;

	public PNote(int pitch, int octave, float duration, int velocity) {
		super(pitch, octave, duration, velocity);
	}

	public PNote setTimeSig(int[] t) {
		if (t.length != 2) {
			throw new IllegalArgumentException();
		} else {
			time = t;
		}
		return this;
	}

	public int[] getTimeSig() {
		return time;
	}

	public PNote setKey(Key k) {
		if (k == null) {
			throw new IllegalArgumentException();
		} else {
			key = k;
		}
		return this;
	}

	public Key getKey() {
		return key;
	}

	public PNote setTempo(int t) {
		if (t <= 0) {
			throw new IllegalArgumentException();
		} else {
			tempo = t;
		}
		return this;
	}

	public int getTempo() {
		return tempo;
	}
}
