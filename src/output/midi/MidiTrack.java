package output.midi;

import javax.sound.midi.*;

public class MidiTrack  {
    private Instrument instrument;
    private Track track;
    
    public Track getTrack() {
        return track;
    }
    
    public MidiTrack(Track t) {
        this.track = t;
    }
    
    // Extended track methods **
    
    public void SetTempo() throws InvalidMidiDataException {
        addMessage(message(MetaType.Tempo, new byte[]{0x02, (byte) 0x00, 0x00}), 0);
    }
    public void setTrackName(String name) throws InvalidMidiDataException {
        addMessage(message(MetaType.TrackName, name.getBytes()), 0);
    }
    public void addNote(int pitch, int velocity, int duration, long time) throws InvalidMidiDataException {
        addMessage(message(ShortMessage.NOTE_ON, pitch, velocity), time);
        addMessage(message(ShortMessage.NOTE_OFF, pitch, velocity), time + duration);
    }
    public void addNote(int pitch, int velocity, int duration, long time, Instrument i) throws InvalidMidiDataException {
        Instrument current = instrument;
        setInstrument(i, time);
        addNote(pitch, velocity, duration, time);
        setInstrument(current, time);
    }
    public void setInstrument(Instrument i, long time) throws InvalidMidiDataException {
        if (i != null && i != instrument) {
            addMessage(message(0xC0, i.value), time);
            instrument = i;
        }
    }
    public void endTrack(long time) throws InvalidMidiDataException {
        addMessage(message(MetaType.EndOfTrack, new byte[]{}), time);
    }
    // **  
    
    /*
    
    http://www.indiana.edu/~emusic/etext/MIDI/chapter3_MIDI7.shtml
    
    public void Poly() throws InvalidMidiDataException {
        addMessage(message(ShortMessage.CONTROL_CHANGE, 0x7F), 0);
    }
    public void Omni() throws InvalidMidiDataException {
        addMessage(message(ShortMessage.CONTROL_CHANGE, 0x7D), 0);
    }
    */
    
    private void addMessage(MidiMessage m,long t) { track.add(new MidiEvent(m, t)); }
    
    private MetaMessage message(MetaType eventcode, byte[] data) throws InvalidMidiDataException {
        MetaMessage m = new MetaMessage();
        m.setMessage(eventcode.value, data, data.length);
        return m;
    }
    private ShortMessage message(int eventcode, int data1, int data2) throws InvalidMidiDataException {
        ShortMessage m = new ShortMessage();
        m.setMessage(eventcode, data1, data2);
        return m;
    }
    private ShortMessage message(int eventcode, int data1) throws InvalidMidiDataException {
        ShortMessage m = new ShortMessage();
        m.setMessage(eventcode, data1, 0x00);
        return m;
    }
    
}
