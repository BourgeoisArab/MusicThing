package main;
import java.util.*;

public class Timeline {
    private int t;
    private List<Note> timeline;
    
    public Timeline()
    {
        timeline = new ArrayList<>();
        //timeline.add(new Note(1,1,1));
        t = 0;
    }
    
    public Note NextNote()
    {
        return ( timeline.isEmpty() ? null : timeline.get(t++) );
    }
    
    public boolean AppendNote(Note e)
    {
        return timeline.add(e);
    }
    
    public boolean AppendNote(Collection<Note> c)
    {
        return timeline.addAll(c);
    }
}
