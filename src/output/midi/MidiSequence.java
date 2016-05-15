package output.midi;

import javax.sound.midi.Sequence;

import core.Note;

public class MidiSequence {

	/**
	 * Ticks per second
	 */
	public static final float tps = 5.208e-3F;

	// Track -> sequence.getTracks[i]
	public Sequence sequence;
	public MidiTrack track;

	public MidiSequence() // throws InvalidMidiDataException
	{
		try {
			sequence = new Sequence(javax.sound.midi.Sequence.PPQ, 24);
			track = new MidiTrack(sequence.createTrack());
		} catch (Exception e) {
			System.out.println("MidiSequence init: " + e.getMessage());
		}
	}

	/*
	 * public void AppendMessage(MidiMessage m, long t) { track.add(new MidiEvent(m, t)); }
	 */

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
		// return (int) (duration * timesig[1] * 60 * tps / tempo);
		/*
		 * float qDuration = duration * timesig[1]; float tempoRatio = 60.0F / (float)tempo; System.out.println(tempoRatio); return (int)( qDuration * tempoRatio * 10e3 / tps);
		 */
		return (int) (duration * timesig[1] * 60 / tempo / tps);
	}

}
