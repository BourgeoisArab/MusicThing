package gen;

public class Instrument {

	public static Instrument piano = new Instrument(0x00);
	// TODO: Add more static instruments here

	public final int value;

	public Instrument(int value) {
		this.value = value;
	}

}
