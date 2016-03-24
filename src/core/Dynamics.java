package core;

public class Dynamics {

	public static Dynamics ppp = new Dynamics(20);
	public static Dynamics pp = new Dynamics(31);
	public static Dynamics p = new Dynamics(42);
	public static Dynamics mp = new Dynamics(53);
	public static Dynamics mf = new Dynamics(64);
	public static Dynamics f = new Dynamics(80);
	public static Dynamics ff = new Dynamics(96);
	public static Dynamics fff = new Dynamics(112);

	public final byte value;

	protected Dynamics(int value) {
		this.value = (byte) value;
	}

}
