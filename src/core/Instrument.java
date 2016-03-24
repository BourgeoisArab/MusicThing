package core;

public class Instrument {

	public static Instrument piano = new Instrument(0x00);
	public static Instrument harpsichord = new Instrument(0x07);

	public static Instrument violin = new Instrument(0x29);
	public static Instrument cello = new Instrument(0x2B);

	public static Instrument flute = new Instrument(0x4A);

	public static Instrument marimba = new Instrument(0x0D);
	public static Instrument xylophone = new Instrument(0x0E);
	// TODO: Add more static instruments here

	public final int value;

	/**
	 * Visit <a href="http://www.pgmusic.com/tutorial_gm.htm">here</a> for instrument codes
	 * 
	 * @param value
	 */
	protected Instrument(int value) {
		this.value = value;
	}

}
