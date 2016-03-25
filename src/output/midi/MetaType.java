package output.midi;

public enum MetaType {
    SequenceNumber(0x00),
    TextEvent(0x01),
    EndOfTrack(0x2F),
    TrackName(0x03),
    Instrument(0xC0),
    Tempo(0x51);
    //...

    public final int value;

    private MetaType(int value) {
        this.value = value;
    }
}
