package output;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.MidiSystem;

import output.midi.MidiSequence;
import core.Note;

public class Output {

	// Middle layer between data structure and TrackClass
	// Dealing with parameter notes
	public static File write(MidiSequence m, String dir) throws IOException {
            File f = new File(dir);
            MidiSystem.write(m.sequence, 1, f);
            System.out.println("File written to: " + dir);
            return f;
	}
}
