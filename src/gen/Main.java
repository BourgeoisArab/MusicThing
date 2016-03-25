package gen;

import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import output.*;
import output.midi.*;
import core.*;

public class Main {
	public static void main(String[] args) throws InvalidMidiDataException, IOException {
                MidiSequence s = new MidiSequence();
                Key k = Key.keys_major[5];
		Note n = new Note(0, 1, Dynamics.f);
		//TrackClass t = new TrackClass();
		
		s.track.setInstrument(Instrument.marimba, 0);
		s.track.addNote(0x3C, 80, 240, 1);
		s.track.addNote(0x3F, 80, 240, 1);
		s.track.addNote(0x42, 80, 240, 1);
		s.track.addNote(0x45, 80, 240, 1);
		s.track.endTrack(250);
		Output.write(s,"C:\\Dev\\music\\MusicThingy\\midifile.mid");
                
                
	}
}
