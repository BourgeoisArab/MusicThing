package core;

import java.util.ArrayList;
import java.util.List;

public class Chord {
    public int P0;
    public List<Integer> intervalPitches;
    
    public Chord(int p0, List<Integer> iP) {
        P0 = p0;
        intervalPitches = iP;
    }
}
