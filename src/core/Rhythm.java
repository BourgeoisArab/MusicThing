package core;

public class Rhythm {
    // Rhythm's notes ratio based on duration
    public int[] ratio;
    // Note duration 1/4 - crotchet
    public int total_duration;
    
    // 2 Eighth notes - td = 1/4, r = 1/2, 1/2
    /**
     * 
     * @param r - rhythmic ratios, r sum <= 1
     * @param td - rhythm's total duration relative to that of a semi-breve (1)
     */
    public Rhythm(int [] r,int td)
    {
        ratio = r;
        total_duration = td;
    }
    public boolean compareTo(Rhythm r) 
    {
       return this.ratio == r.ratio;
    }
        public int[] abosoluteRatio()
    {
        int[] absoluteRatio = new int[ratio.length];
        for(int i = 0;i < ratio.length-1;i++)
            absoluteRatio[i] = ratio[i] * total_duration;
        return absoluteRatio;
    }
    public int absoluteDuration()
    {
        int absoluteDuration = 0;
        for(int i = 0;i < ratio.length-1;i++)
            absoluteDuration += ratio[i];
        return absoluteDuration * total_duration;
    }
    
    
    public static Rhythm[] split(int step) // Splits d and ratios symmetrically by step(ratio)
    {
         return new Rhythm[]{};
    } 
    public static Rhythm combine(Rhythm c) // Combined ratios, increased d
    {
        return new Rhythm(new int[1],0);     
    }
    public static Rhythm merge(Rhythm c) // merged rations, same d
    {
        return new Rhythm(new int[1],0);
    }
}


