package core;

public class _ParameterNote extends Note {
    public int[] time; 
    public Key key;
    public int tempo;
    
    
    public _ParameterNote(int pitch, float duration, int velocity) {
        super(pitch, duration, velocity);
    }
}
