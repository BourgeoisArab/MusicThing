package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Timeline {

	private int t;
	public List<List<Note>> timeline;

	public Timeline() {
		timeline = new ArrayList<>();
		// timeline.add(new Note(1,1,1));
		t = 0;
	}

	public List<Note> NextNote() {
		return timeline.isEmpty() ? null : timeline.get(t++);
	}      
}
