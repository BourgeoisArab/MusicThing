package core;

public enum Dynamics {

    ppp(20), pp(31), p(42), mp(53), mf(64), f(80), ff(96), fff(112);

    public final byte value;

    private Dynamics(int value) {
        this.value = (byte) value;
    }

}
