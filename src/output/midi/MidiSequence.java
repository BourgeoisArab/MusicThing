package output.midi;

import javax.sound.midi.Sequence;

public class MidiSequence {

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

}
