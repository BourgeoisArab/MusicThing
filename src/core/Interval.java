package core;

public enum Interval {

	P0, m2, M2, m3, M3, P4, d5, P5, m6, M6, m7, M7, P8;

	public int value() {
            return ordinal();
	}

	/**
	 * Moves interval by number of given octaves
	 */
	public int compound(int octaves) {
            return value() + Key.semitones * octaves;
	}

}
