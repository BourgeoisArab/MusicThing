package gen;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import output.TrackClass;
import core.Dynamics;
import core.Instrument;
import core.Key;
import core.Note;

public class Main {

	public static void main(String[] args) throws InvalidMidiDataException, IOException {
		TrackClass t = new TrackClass();
		Key k = Key.keys_major[5];
		Note n = new Note(0, 1, Dynamics.f);
		t.setInstrument(Instrument.marimba, 0);
		t.addNote(0x3C, 80, 240, 1);
		t.addNote(0x3F, 80, 240, 1);
		t.addNote(0x42, 80, 240, 1);
		t.addNote(0x45, 80, 240, 1);
		t.endTrack(250);
		t.write("C:\\Dev\\music\\MusicThingy\\midifile.mid");
	}
}
