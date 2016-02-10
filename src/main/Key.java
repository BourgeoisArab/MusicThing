package main;

public class Key {

	/**
	 * Array storing all the keys, starting with C major
	 */
	public static Key[] keys_major = new Key[12];

	static {
		// Populates array with all major keys
		for (int i = 0; i < keys_major.length; i++) {
			keys_major[i] = new Key(440F * (float) Math.pow(2, (i - 9) / 12F), true);
		}
	}

	/**
	 * The absolute frequency of middle octave tonic
	 */
	private float freq;

	/**
	 * Major or minor key
	 */
	private boolean major;
	private int[] tones;

	public Key(float frequency, boolean major) {
		freq = frequency;
		this.major = major;
		if (major) {
			tones = new int[]{0, 2, 4, 5, 7, 9, 11};
		} else {
			tones = new int[]{0, 2, 3, 5, 7, 8, 11};
		}
	}

	public float getToneFrequency(int note, int octave) {
		// Check the math
		return (float) (440 * Math.pow(2, (12 * (octave - 4) + tones[note] - 49) / 12F));
	}

	public static Note flat(Note note) {
		return note.setFrequency((float) (note.getFrequency() / Math.pow(2, 1 / 12)));
	}

	public static Note sharp(Note note) {
		return note.setFrequency((float) (note.getFrequency() * Math.pow(2, 1 / 12)));
	}

}
