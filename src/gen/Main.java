package gen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import output.Output;
import output.midi.Instrument;
import output.midi.MidiSequence;
import core.Dynamics;
import core.Interval;
import core.Key;
import core.Note;

public class Main {

	public static void main(String[] args) throws InvalidMidiDataException, IOException {
		MidiSequence s = new MidiSequence();
		Key k = Key.keys_major[0];
		List<Note> notes = new ArrayList<Note>();
		s.track.setTrackName("Testificate over 9000");
		s.track.SetTempo(0);
		s.track.setInstrument(Instrument.piano, 0);

		notes.add(new Note(0, 1, Dynamics.f));
		// Way up
		for (int i = 1; i < Key.semitones; i++) {
			notes.add(k.getRelNote(notes.get(i - 1), Interval.m2, false));
		}
		// Way down
		for (int i = notes.size() - 1; i > 0; i--) {
			notes.add(notes.get(i - 1).copy());
		}

		for (int i = 0; i < notes.size(); i++) {
			Note n = notes.get(i);
			s.track.addNote(n.getAbsPitch(k), n.velocity, 50, 50 * i);
		}

		s.track.endTrack(notes.size() * 50 + 150);
		Output.write(s, "C:\\Dev\\music\\MusicThingy\\midifile.mid");
	}
}
