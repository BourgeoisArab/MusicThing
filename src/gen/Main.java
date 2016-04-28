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
		// System.out.println(new MidiSequence().getTickDuration(0.25F, new int[]{4,4}, 120));

		MidiSequence s = new MidiSequence();
		Key k = Key.keys_major[0];
		List<Note> notes = new ArrayList<Note>();
		s.track.setTrackName("Testificate over 9000");
		s.track.SetTempo(0);
		s.track.setInstrument(Instrument.piano, 0);

		int[] timesig = new int[]{4, 4};
		int tempo = 120;

		notes.add(new Note(0, 0.5F, Dynamics.f));
		// Way up
		for (int i = 1; i < Key.semitones; i++) {
			notes.add(k.getRelNote(notes.get(i - 1), Interval.m2, true));
		}
		// Way down
		for (int i = notes.size() - 1; i > 0; i--) {
			notes.add(notes.get(i - 1).copy());
		}

		for (int i = 0; i < notes.size(); i++) {
			Note n = notes.get(i);
			s.track.addNote(n.getAbsPitch(k), s.getTickDuration(n, timesig, tempo), 50, 50 * i);
		}

		s.track.endTrack(notes.size() * 50 + 150);
		Output.write(s, "C:\\Users\\Jakoubeck\\Desktop\\midifile.mid");
	}
}
