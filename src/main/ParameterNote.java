package main;

public class ParameterNote extends Note {
    private int[] timeSignature;
    private Key key;
    
    public ParameterNote(int p, float f, float d,int[] ts,Key k)
    {
        super(p,f,d);
        key = k;
        timeSignature = ts;
    }
    
    public int[] GetTimeSig() { return timeSignature; }
    
    public void SetTimeSig(int[] ts) { timeSignature = ts; }
    
    public Key GetKey() { return key; }
    
    public void SetKey(Key k) { key = k; }
}
