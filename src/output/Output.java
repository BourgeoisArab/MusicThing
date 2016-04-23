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
	public static final float tps = 2.604e-3F;

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
	public int getTickDuration(Note n, int[] timesig, int tempo) {
		return getTickDuration(n.duration, timesig, tempo);
	}

	public int getTickDuration(float duration, int[] timesig, int tempo) {
		//return (int) (duration * timesig[1] * 60 * tps / tempo);
                /*float qDuration = duration * timesig[1];
                float tempoRatio = 60.0F  / (float)tempo;
                System.out.println(tempoRatio);
                return (int)( qDuration * tempoRatio * 10e3 / tps);*/
                return (int)( duration * timesig[1] * 60 / tempo / tps );
	}
}
