package core;

import java.util.ArrayList;
import java.util.List;

public class Chord {

	public static enum Type {
		major, minor, open, major7th, sus;
	}

	public int tonic;
	public List<Integer> pitches;
	public Type type;

	public Chord(int tonic, List<Integer> pitches) {
		this.tonic = tonic;
		this.pitches = pitches;
	}

	public Chord(int tonic, Type type, int... otherNotes) {
		this.tonic = tonic;
		pitches = new ArrayList<Integer>();
		pitches.add(tonic);
		pitches.add(tonic + Interval.P5.value());
		if (type == Type.major || type == Type.major7th) {
			pitches.add(tonic + Interval.M3.value());
			if (type == Type.major7th) {
				pitches.add(tonic + Interval.m7.value());
			}
		} else if (type == Type.minor) {
			pitches.add(tonic + Interval.m3.value());
		}

		for (int i = 0; i < otherNotes.length; i++) {
			pitches.add(i);
		}
	}

}
