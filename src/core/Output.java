package core;

import gen.Instrument;

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

public class Output {

	public static class TrackClass {

		protected Sequence s;
		protected Track t = s.createTrack();
		protected Instrument instrument = Instrument.piano;

		public TrackClass() throws InvalidMidiDataException {
			s = new Sequence(javax.sound.midi.Sequence.PPQ, 24);

			// **** General MIDI sysex -- turn on General MIDI sound set ****
			byte[] b = {(byte) 0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte) 0xF7};
			SysexMessage sm = new SysexMessage();
			sm.setMessage(b, 6);
			addMessage(sm, 0);

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

		public void setName(String name) throws InvalidMidiDataException {
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
				addMessage(message(0xC0, 0x00, 0x00), time);
				instrument = i;
			}
		}

		public void addNote(int pitch, int velocity, long time, int duration) throws InvalidMidiDataException {
			addMessage(message(0x90, pitch, velocity), time);
			addMessage(message(0x80, pitch, velocity), time + duration);
		}

		public void endTrack(long time) throws InvalidMidiDataException {
			addMessage(message(0x2F, new byte[]{}, 0), time);
		}

		public File write(String dir) throws IOException {
			File f = new File("midifile.mid");
			MidiSystem.write(s, 1, f);
			return f;
		}

	}

}
