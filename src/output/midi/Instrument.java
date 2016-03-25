package output.midi;

public enum Instrument {
    piano(0x00), 
    harpsichord(0x07), 
    violin(0x29), 
    cello(0x2B), 
    flute(0x4A), 
    marimba(0x0D), 
    xylophone(0x0E);

    // TODO:    Add more instruments here

    public final int value;

    /**
     * Visit <a href="http://www.pgmusic.com/tutorial_gm.htm">here</a> for instrument codes
     * 
     * @param value
     */
    private Instrument(int value) {
            this.value = value;
    }
}
