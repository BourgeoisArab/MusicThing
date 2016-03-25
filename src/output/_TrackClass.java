package output;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Track;

import output.midi.Instrument;

public class _TrackClass {

	protected Sequence s;
	protected Track t;
	protected Instrument instrument = Instrument.piano;

	public _TrackClass() throws InvalidMidiDataException {
		s = new Sequence(javax.sound.midi.Sequence.PPQ, 24);
		t = s.createTrack();

		// **** General MIDI sysex -- turn on General MIDI sound set ****
		byte[] b = {(byte) 0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte) 0xF7};
		SysexMessage sm = new SysexMessage();
		sm.setMessage(b, 6);
		addMessage(sm, 0);

		setTrackName("track1");
		// **** set tempo (meta event) ****
		addMessage(message(0x51, new byte[]{0x02, (byte) 0x00, 0x00}, 3), 0);
		// **** set omni on ****
		addMessage(message(0xB0, 0x7D, 0x00), 0);
		// **** set poly on ****
		addMessage(message(0xB0, 0x7F, 0x00), 0);
                
	}

	public void addMessage(MidiMessage m, long time) {
		t.add(new MidiEvent(m, time));
	}

	public void addMessage(int data1, byte[] data, int length, long time) throws InvalidMidiDataException {
		addMessage(message(data1, data, length), time);
	}

	public void addMessage(int status, int data1, int data2, long time) throws InvalidMidiDataException {
		addMessage(message(status, data1, data2), time);
	}

	public void setTrackName(String name) throws InvalidMidiDataException {
		addMessage(message(0x03, name.getBytes(), name.length()), 0);
	}

	public MetaMessage message(int data1, byte[] data, int length) throws InvalidMidiDataException {
		MetaMessage m = new MetaMessage();
		m.setMessage(data1, data, length);
		return m;
	}

	public ShortMessage message(int status, int data1, int data2) throws InvalidMidiDataException {
		ShortMessage m = new ShortMessage();
		m.setMessage(status, data1, data2);
		return m;
	}

	public void setInstrument(Instrument i, long time) throws InvalidMidiDataException {
		if (i != null && i != instrument) {
			addMessage(message(0xC0, i.value, 0x00), time);
			instrument = i;
		}
	}

	public void addNote(int pitch, int velocity, int duration, long time) throws InvalidMidiDataException {
		addMessage(ShortMessage.NOTE_ON, pitch, velocity, time);
		addMessage(ShortMessage.NOTE_OFF, pitch, velocity, time + duration);
	}

	public void addNote(int pitch, int velocity, int duration, long time, Instrument i) throws InvalidMidiDataException {
		Instrument current = instrument;
		setInstrument(i, time);
		addNote(pitch, velocity, duration, time);
		setInstrument(current, time);
	}

	public void endTrack(long time) throws InvalidMidiDataException {
		addMessage(message(0x2F, new byte[]{}, 0), time);
	}

	public File write(String dir) throws IOException {
		File f = new File(dir);
		MidiSystem.write(s, 1, f);
		System.out.println("File written to: " + dir);
		return f;
	}
}
