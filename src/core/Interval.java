package core;

public enum Interval {

	P0(0), m2(1), M2(2), m3(3), M3(4), P4(5), d5(6), P5(7), m6(8), M6(9), m7(10), M7(11), P8(12);

	public final int value;

	private Interval(int semitones) {
		value = semitones;
	}

	/**
	 * Moves interval by number of given octaves
	 */
	public int compound(int octaves) {
		return value + Key.semitones * octaves;
	}

}
