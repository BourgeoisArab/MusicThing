package output;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.MidiSystem;

import output.midi.MidiSequence;
import core.Note;

public class Output {

	/**
	 * Ticks per second
	 */
	public static final float tps = 2.604F;

	// Middle layer between data structure and TrackClass
	// Dealing with parameter notes
	public static File write(MidiSequence m, String dir) throws IOException {
		File f = new File(dir);
		MidiSystem.write(m.sequence, 1, f);
		System.out.println("File written to: " + dir);
		return f;
	}

	/**
	 * @param duration
	 * @param timesig
	 * @param tempo
	 * @return number of midi ticks for which the note lasts
	 */
	public int getAbsDuration(Note n, int[] timesig, int tempo) {
		return getAbsDuration(n.duration, timesig, tempo);
	}

	public int getAbsDuration(float duration, int[] timesig, int tempo) {
		return (int) (duration * timesig[1] * 60 * tps / tempo);
	}
}
